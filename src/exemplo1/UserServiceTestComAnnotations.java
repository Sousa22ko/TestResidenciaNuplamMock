package exemplo1;

import static org.mockito.Mockito.*;

import java.util.Collections;

import org.junit.Ignore;
import org.junit.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.InOrder;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import org.junit.Before;
import static org.junit.Assert.*;
import static org.mockito.Mockito.*;
import static org.mockito.ArgumentMatchers.*;

public class UserServiceTestComAnnotations {

	private static final String PASSWORD = "password";

	private static final User ENABLED_USER = new User("user id", "hash", true);

	private static final User DISABLED_USER = 
			            new User("desabilitado id", "desabilitado hash", false);

	@InjectMocks
	private UserService userService;

	@Mock
	private UserRepository mockUserRepository;

	@Mock
	private PasswordEncoder mockPasswordEncoder;

	@Before
	public void initMocks() {
		MockitoAnnotations.initMocks(this);

		when(mockUserRepository.findById(ENABLED_USER.getId())).thenReturn(ENABLED_USER);
		when(mockUserRepository.findById(DISABLED_USER.getId())).thenReturn(DISABLED_USER);

		when(mockPasswordEncoder.encode(anyString())).thenReturn("any password hash");
		when(mockPasswordEncoder.encode(PASSWORD)).thenReturn(ENABLED_USER.getPasswordHash());
	}

	// @Before
	// public void setup() {
	// userRepository = criaRepositorio();
	// passwordEncoder = criaPasswordEncoder();
	// userService = new UserService(userRepository, passwordEncoder);
	// }

	@Test
	public void validoParaCredenciaisValidas() throws UserNotFoundException {
		boolean userIsValid = userService.isValidUser(ENABLED_USER.getId(), PASSWORD);
		assertTrue(userIsValid);

		// userRepository had to be used to find a user with id="user id"
		verify(mockUserRepository).findById(ENABLED_USER.getId());

		// passwordEncoder had to be used to compute a hash of "password"
		verify(mockPasswordEncoder).encode(PASSWORD);
		
		
		InOrder inOrder = inOrder(mockUserRepository, mockPasswordEncoder);
		
		inOrder.verify(mockUserRepository).findById(ENABLED_USER.getId());
		inOrder.verify(mockPasswordEncoder).encode(PASSWORD);
			
	}
	
	
	@Test
	public void invalidoParaUsuarioDesabilitado() throws UserNotFoundException {
		boolean userIsValid = userService.isValidUser(DISABLED_USER.getId(), PASSWORD);
		assertFalse(userIsValid);

		verify(mockUserRepository).findById(DISABLED_USER.getId());
		verifyZeroInteractions(mockPasswordEncoder);
	}


	@Test
	public void invalidoParaCredenciaisInvalidas() throws UserNotFoundException {
		boolean userIsValid = userService.isValidUser("invalid id", PASSWORD);
		assertFalse(userIsValid);

		InOrder inOrder = inOrder(mockUserRepository, mockPasswordEncoder);
			
		inOrder.verify(mockPasswordEncoder, never()).encode(anyString());
		inOrder.verify(mockUserRepository).findById("invalid id");
	}

	@Test
	public void invalidoParaSenhaInvalida() throws UserNotFoundException {
		boolean userIsValid = userService.isValidUser(ENABLED_USER.getId(), "invalid");
		assertFalse(userIsValid);

		// TODO: NAO entendi
		ArgumentCaptor<String> passwordCaptor = ArgumentCaptor.forClass(String.class);
		verify(mockPasswordEncoder).encode(passwordCaptor.capture());
		assertEquals("invalid", passwordCaptor.getValue());
	}

	@Test(expected = UserNotFoundException.class)
	public void invalidoIdUsuario() {
		boolean userIsValid = userService.isValidUser("alo", "invalid");
		assertFalse(userIsValid);
	}

}
