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


public class UserServiceTest {

   private static final String PASSWORD = "password";

   private static final User ENABLED_USER =
           new User("user id", "hash", true);

   private static final User DISABLED_USER =
           new User("desabilitado id", "desabilitado hash" , false);
  
   
   private UserRepository userRepository;
   private PasswordEncoder passwordEncoder;
   private UserService userService;
   
   
   @Before
   public void setup() {
       userRepository = criaRepositorio();
       passwordEncoder = criaPasswordEncoder();
       userService = new UserService(userRepository, passwordEncoder);
   }

   @Test
   public void validoParaCredenciaisValidas() throws UserNotFoundException {
       boolean userIsValid = userService.isValidUser(ENABLED_USER.getId(), PASSWORD);
       assertTrue(userIsValid);

       // userRepository had to be used to find a user with id="user id"
       verify(userRepository).findById(ENABLED_USER.getId());

       // passwordEncoder had to be used to compute a hash of "password"
       verify(passwordEncoder).encode(PASSWORD);
   }

   @Test
   public void invalidoParaUsuarioDesabilitado() throws UserNotFoundException {
       boolean userIsValid = userService.isValidUser(DISABLED_USER.getId(), PASSWORD);
       assertFalse(userIsValid);
       
       verify(userRepository).findById(DISABLED_USER.getId());
       verifyZeroInteractions(passwordEncoder);
   }

   
   @Test
   public void invalidoParaCredenciaisInvalidas() throws UserNotFoundException {
       boolean userIsValid = userService.isValidUser("invalid id", PASSWORD);
       assertFalse(userIsValid);

       // TODO: Nao entendi
       InOrder inOrder = inOrder(userRepository, passwordEncoder);
       inOrder.verify(userRepository).findById("invalid id");
       inOrder.verify(passwordEncoder, never()).encode(anyString());
   }

   @Test
   public void invalidoParaSenhaInvalida() throws UserNotFoundException {
       boolean userIsValid = userService.isValidUser(ENABLED_USER.getId(), "invalid");
       assertFalse(userIsValid);

       // TODO: NAO entendi
       ArgumentCaptor<String> passwordCaptor = ArgumentCaptor.forClass(String.class);
       verify(passwordEncoder).encode(passwordCaptor.capture());
       assertEquals("invalid", passwordCaptor.getValue());
   }


   private PasswordEncoder criaPasswordEncoder() {
       PasswordEncoder mock = mock(PasswordEncoder.class);
       when(mock.encode(anyString())).thenReturn("any password hash");
       when(mock.encode(PASSWORD)).thenReturn(ENABLED_USER.getPasswordHash());
       return mock;
   }

   private UserRepository criaRepositorio() {
       UserRepository mock = mock(UserRepository.class);
       when(mock.findById(ENABLED_USER.getId())).thenReturn(ENABLED_USER);
       when(mock.findById(DISABLED_USER.getId())).thenReturn(DISABLED_USER);
       return mock;
   }
}
