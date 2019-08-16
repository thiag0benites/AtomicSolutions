package api.rest;

import static com.jayway.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import java.io.IOException;
import java.net.URI;

import static com.jayway.restassured.module.jsv.JsonSchemaValidator.*;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClientBuilder;
import org.junit.Test;

import com.jayway.restassured.http.ContentType;
import api.slack.*;


public class TestAPI {
	
	public TestAPI() {
		baseURI = "https://jsonplaceholder.typicode.com/todos/";
	}

	@Test
	public void test() {
		
		
		 given()
		 .when()
		    .get("/1")
		 .then()
		    .statusCode(200)
		    .body("userId", is(1))
		    .body("id", is(1))
		    .body("title", equalTo("delectus aut autem"))
		    .body("completed", equalTo(false))
		    .assertThat()
		       .body(matchesJsonSchemaInClasspath("schema.json"));
		
			
//	      SlackMessage slackMessage = SlackMessage.builder()
//	        .channel("#geral")
//	        .username("Thiago Benites")
//	        .text("Github: https://github.com/thiag0benites/AtomicSolutions.git")
//	        .icon_emoji(":twice:")
//	        .build();
//	      SlackUtils.sendMessage(slackMessage);
	}

}
