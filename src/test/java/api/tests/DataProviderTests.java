package api.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import api.endpoints.UserEndPoints;
import api.payload.User;
import api.utilities.DataProviders;
import io.restassured.response.Response;

public class DataProviderTests {
	
	@Test(priority = 1, dataProvider = "data", dataProviderClass = DataProviders.class)
	public void testPostUser(String userId, String userName, String firstName, String lastName, String email, String password, String phone) {
		User myUser = new User();
		
		myUser.setId(Integer.parseInt(userId));
		myUser.setEmail(email);
		myUser.setFirstName(firstName);
		myUser.setLastName(lastName);
		myUser.setPassword(password);
		myUser.setPhone(phone);
		myUser.setUsername(userName);
		
		Response response = UserEndPoints.createUser(myUser);
		
		Assert.assertEquals(200, response.getStatusCode());
	}
	
	@Test(priority=2, dataProvider="usernames", dataProviderClass=DataProviders.class)
	public void testDeleteUser(String userName) {
		
		Response response = UserEndPoints.deleteUser(userName);
		
		Assert.assertEquals(200, response.getStatusCode());
	}

}
