package fileuploadanddownload;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import  static org.hamcrest.Matchers.*;

import java.io.File;
public class FileUpload {

	@Test
private void SingleFileUplaod()
	{
		
		given()
		File f= new File("D:\\Jenkins.txt");
		.when()
		.post("http://localhost:8080/uploadFile")
		.then()
		.assertThat().statusCode(200).
		;
	}
}
