package api.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;

import api.endpoints.UserEndPoints;
import api.payload.User;
import io.restassured.response.Response;

public class UserTests {
	Faker faker;
	User userPayLoad;
	String username;
	
	@BeforeClass
	void setupData() {
		faker = new Faker();
		userPayLoad = new User();
		
		userPayLoad.setId(faker.idNumber().hashCode());
		userPayLoad.setUsername(faker.name().username());
		userPayLoad.setFirstName(faker.name().firstName());
		userPayLoad.setLastName(faker.name().lastName());
		userPayLoad.setEmail(faker.internet().safeEmailAddress());
		userPayLoad.setPassword(faker.internet().password(5, 10));
		userPayLoad.setPhone(faker.phoneNumber().cellPhone());
	}
	
	@Test(priority = 1)
	void testCreateUser() {
		Response response = UserEndPoints.createUser(userPayLoad);
		response.then().log().all();
		
		Assert.assertEquals(response.statusCode(),200);
	}
	
	@Test(priority = 2)
	void testGetUser() {
		
		Response response = UserEndPoints.getUser(this.userPayLoad.getUsername());
		response.then().log().all();
		
		Assert.assertEquals(response.statusCode(),200);
	}
	
	@Test(priority = 3)
	void testUpdateUser() {
		
		// update details
		userPayLoad.setUsername(faker.name().username());
		userPayLoad.setFirstName(faker.name().firstName());
		userPayLoad.setLastName(faker.name().lastName());
		
		Response response = UserEndPoints.updateUser(this.userPayLoad.getUsername(), userPayLoad);
		response.then().log().all();
		
		Assert.assertEquals(200, response.statusCode());
		
		// Checking data after update
		Response responseAfterUpdate = UserEndPoints.getUser(this.userPayLoad.getUsername());
		responseAfterUpdate.then().log().body();
		
		Assert.assertEquals(200, responseAfterUpdate.getStatusCode());
	}
	
	@Test(priority = 4)
	void testDeleteUser() {
		
		Response response = UserEndPoints.deleteUser(this.userPayLoad.getUsername());
		response.then().log().all();
		
		Assert.assertEquals(200, response.getStatusCode());
	}
}
