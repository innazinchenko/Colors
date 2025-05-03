package ait.imagga;

import ait.imagga.colors.Response;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

public class ImaggaColorsAppl {
    public static void main(String[] args) {

        String imageUrl = "https://imagga.com/static/images/tagging/wind-farm-538576_640.jpg";


        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.add("Authorization", "Basic YWNjX2JmNGNjMWU0MDYyN2I2NzpjNTJkYWVkZjIxZDcwNDgwYjcxZGMzODE2NTlkOGJlNA==");
        UriComponentsBuilder builder = UriComponentsBuilder.fromUriString("https://api.imagga.com/v2/colors")
                .queryParam("image_url", imageUrl);
        URI uri = builder.build().toUri();
        RequestEntity<String> request = new RequestEntity<>(headers, HttpMethod.GET, uri);

        ResponseEntity<Response> response = restTemplate.exchange(request,Response.class);
        response.getBody().getResult().getColors().getBackground_colors().forEach(System.out::println);
        response.getBody().getResult().getColors().getForeground_colors().forEach(System.out::println);
        response.getBody().getResult().getColors().getImage_colors().forEach(System.out::println);

    }
}
