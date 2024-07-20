package api.endpoints;

import static io.restassured.RestAssured.*;

import api.payload.User;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class UserEndPoints {
	
	
	public static Response createUser(User payload){
		
		Response response = given()
								.accept(ContentType.JSON)
								.contentType(ContentType.JSON)
								.body(payload)
								.log().uri()
								.log().body()
							.when()
								.post(Routes.createUser);
		
		System.out.println(payload.getUsername());
		
		return response;
	}
	
	
	public static Response getUser(String userName) {
		System.out.println(userName);
		Response response = given()
								.accept(ContentType.JSON)
								.pathParam("username", userName)
								.log().uri()
							.when()
								.get(Routes.getUser);	
		return response;
	}
	

	public static Response updateUser(String userName, User payload) {
		Response response = given()
								.accept(ContentType.JSON)
								.contentType(ContentType.JSON)
								.pathParam("username", userName)
								.log().uri()
								.body(payload)
							.when()
								.put(Routes.updateUser);
		
		return response;
	}
	
	public static Response deleteUser(String userName) {
		Response response = given()
								.pathParam("username", userName)
							.when()
								.delete(Routes.deleteUser);
		return response;
	}
	
}
