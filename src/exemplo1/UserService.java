package exemplo1;


public class UserService {

   private final UserRepository userRepository;
   private final PasswordEncoder passwordEncoder;

   public UserService(UserRepository userRepository, PasswordEncoder passwordEncoder) {
       this.userRepository = userRepository;
       this.passwordEncoder = passwordEncoder;
   }

   public boolean isValidUser(String id, String password) throws UserNotFoundException {
	   if (id == null || id.equals("")) {
		   throw new UserNotFoundException("usuario invalido");
	   }
	   
       User user = userRepository.findById(id);
       return isEnabledUser(user) && isValidPassword(user, password);
   }

   private boolean isEnabledUser(User user) {
       return user != null && user.isEnabled();
   }

   private boolean isValidPassword(User user, String password) {
       String encodedPassword = passwordEncoder.encode(password);
       return encodedPassword.equals(user.getPasswordHash());
   }
}