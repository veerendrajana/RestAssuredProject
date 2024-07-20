package api.endpoints;

/*
 * Create user - https://petstore.swagger.io/v2/user
 * Get user - https://perstore.swagger.io/v2/user/{username}
 * Update user - https://perstore.swagger.io/v2/user/{username}
 * Delete user - https://perstore.swagger.io/v2/user/{username}
 */

public class Routes {
	
	// baseURL
	public static String baseUrl = "https://petstore.swagger.io/v2";
	
	// CRUD Url's
	public static String createUser = baseUrl + "/user";
	public static String getUser = baseUrl + "/user/{username}";
	public static String updateUser = baseUrl + "/user/{username}";
	public static String deleteUser = baseUrl + "/user/{username}";
	
}
