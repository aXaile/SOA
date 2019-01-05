package fr.insat.om2m.tp2.client;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

import org.apache.commons.io.IOUtils;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpDelete;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;

public class Client implements ClientInterface {

	public Response retrieve(String url, String originator) throws IOException {
		Response response = new Response();
		// Instantiate a new Client
		CloseableHttpClient client = HttpClients.createDefault();
		// Instantiate the correct Http Method
		HttpGet get = new HttpGet(url);
		// add headers
		//TODO
		get.addHeader("x-m2m-origin", originator);
		get.addHeader("Accept", "application/xml");

		try {
			// send request
			CloseableHttpResponse reqResp = client.execute(get);
			response.setStatusCode(reqResp.getStatusLine().getStatusCode());
			response.setRepresentation(IOUtils.toString(reqResp.getEntity()
					.getContent(), "UTF-8"));
		} catch (IOException e1) {
			e1.printStackTrace();
		} finally {
			client.close();
		}
		// return response
		return response;
	}

	public Response create(String url, String representation, String originator, String type) throws IOException {
		Response response = new Response();
		CloseableHttpClient client = HttpClients.createDefault();
		// Instantiate the correct Http Method
		HttpPost post = new HttpPost(url);
		// add headers
		//TODO
		post.addHeader("x-m2m-origin", originator);
		post.addHeader("Content-type", "application/xml;ty="+type);
		post.setEntity(new StringEntity (representation));
		try {
			CloseableHttpResponse reqResp = client.execute(post);
			response.setStatusCode(reqResp.getStatusLine().getStatusCode());
			response.setRepresentation(IOUtils.toString(reqResp.getEntity().getContent(), "UTF-8"));
		}catch(Exception e1) {
			e1.printStackTrace();
		}finally {
			client.close();
		}
		return response;
	}

	public Response update(String url, String representation, String originator) throws IOException {
		Response reponse = new Response();
		CloseableHttpClient client = HttpClients.createDefault();

		// Instantiate the correct Http Method
		HttpPut put = new HttpPut(url);
		// add headers
		//TODO
		put.addHeader("x-m2m-origin", originator);
		put.addHeader("Content-type", "application/xml");
		put.setEntity(new StringEntity (representation));
		try {
			CloseableHttpResponse reqResp = client.execute(put);
			reponse.setStatusCode(reqResp.getStatusLine().getStatusCode());
			reponse.setRepresentation(IOUtils.toString(reqResp.getEntity().getContent(), "UTF-8"));
		}catch(Exception e1) {
			e1.printStackTrace();
		}finally {
			client.close();
		}
		return reponse;
		
	}

	public Response delete(String url, String originator) throws IOException {
		Response reponse = new Response();
		CloseableHttpClient client = HttpClients.createDefault();

		// Instantiate the correct Http Method
		HttpDelete delete = new HttpDelete(url);
		// add headers
		//TODO
		delete.addHeader("x-m2m-origin", originator);
		delete.addHeader("Accept", "application/xml");
		try {
			CloseableHttpResponse reqResp = client.execute(delete);
			reponse.setStatusCode(reqResp.getStatusLine().getStatusCode());
			reponse.setRepresentation(IOUtils.toString(reqResp.getEntity().getContent(), "UTF-8"));
		}catch(Exception e1) {
			e1.printStackTrace();
		}finally {
			client.close();
		}
		return reponse;
		
	}

}
