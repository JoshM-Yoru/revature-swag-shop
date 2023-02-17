package com.revature.swagshop;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;
import com.revature.swagshop.controllers.UserController;
import com.revature.swagshop.exceptions.InvalidCredentialsException;
import com.revature.swagshop.exceptions.UserAlreadyRegisteredException;
import com.revature.swagshop.models.Receipt;
import com.revature.swagshop.models.User;
import com.revature.swagshop.repositories.UserRepository;
import com.revature.swagshop.services.UserService;

@SpringBootTest
public class UserLoginRegisterTest {

  @Autowired
  UserRepository uRepo;

  // Failing test due to user already being registered
  @Test
  public void AlreadyRegisteredUserRepoTest() {
    List<Receipt> receipts = new ArrayList<>();
    User u = new User(0, "RepoTest", "RepoTest", "repotest@test.com", "123repotest", receipts,
        "123test address", "8888888888");

    try {
      uRepo.save(u);
    } catch (UserAlreadyRegisteredException uare) {
      System.out.println("User already registered!");
    }
  }

  @Test
  public void LoginUserTest() {
    User u = uRepo.getByEmail("repotest@test.com").orElseThrow(InvalidCredentialsException::new);
    if (!u.getPassword().equals("123repotest")) {
      throw new InvalidCredentialsException();
    }

    System.out.println("You have logged in!");
  }

  @Test
  public void newRegisteredUserRepoTest() {
    String password = randomString();

    User u = new User("randomTest", "randomTest", password, "123randomtest");

    try {
      uRepo.save(u);
    } catch (UserAlreadyRegisteredException uare) {
      System.out.println("User already registered!");
    }

  }

  public static String randomString() {
    int leftLimit = 97; // letter 'a'
    int rightLimit = 122; // letter 'z'
    int targetStringLength = 10;
    Random random = new Random();
    StringBuilder buffer = new StringBuilder(targetStringLength);
    for (int i = 0; i < targetStringLength; i++) {
      int randomLimitedInt = leftLimit + (int) (random.nextFloat() * (rightLimit - leftLimit + 1));
      buffer.append((char) randomLimitedInt);
    }
    String generatedString = buffer.toString();

    System.out.println(generatedString);

    return generatedString;
  }

}
