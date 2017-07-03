package com.toto.main;

import org.springframework.boot.Banner;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.util.StringUtils;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

/**
 * Created by abhinavganguly on 03/07/2017.
 */

@SpringBootApplication(scanBasePackages = "com.toto")
public class Application implements CommandLineRunner {


//    movieSearchURL= http://moviesapi.com/m.php?r=json&&type=movie&t= //Not using this URL soince it is throwing HTTP 403 error
//    although it  works in POSTman rest client

    private String movieSearchURL="http://apimovies.herokuapp.com/search/";

    private String albumSearchURL="http://api-v2.hearthis.at/search/?count=4&t=";


    public static void main(String[] args){

        //Im just switching off the Spring boot Banner
        SpringApplication app = new SpringApplication(Application.class);
        app.setBannerMode(Banner.Mode.OFF);
        app.run(args);

    }

    @Bean
    public RestTemplate getRestTemplate (RestTemplateBuilder builder){
        return builder.build();
    }


    @Override
    public void run (String... args ) throws Exception{


            String selectedApi = System.getProperty(Constants.apiArg);

            if(StringUtils.isEmpty(selectedApi)){
                System.out.println("\n\n\n No Api specified \n\n\n ");
                System.exit(0);
            }

            String searchTerm = System.getProperty(Constants.searchTermArg);


            if(StringUtils.isEmpty(searchTerm)){
                System.out.println("\n\n\n  No Search Term specified \n\n\n ");
                System.exit(0);
            }

            RestTemplate restTemplate = new RestTemplate();

            if(selectedApi.equalsIgnoreCase("imdb")){

                Movie[] moviesList = restTemplate.getForObject(movieSearchURL+searchTerm,  Movie[].class);

                List<Movie> moviesArrayList = Arrays.asList(moviesList);

                if (!moviesArrayList.isEmpty()){

                    System.out.println("\n\n\n Movies Search Result for : "+searchTerm+"\n\n");

                    moviesArrayList.stream().limit(4).forEach( album -> System.out.println(album.toMovieString()));

                    System.out.println("\n\n ******************************************** \n\n\n");
                }
                System.exit(0);


            }else if(selectedApi.equalsIgnoreCase("album")){


                Movie[] albumList = restTemplate.getForObject(
                        albumSearchURL+searchTerm,  Movie[].class);

                List<Movie> albumArrayList = Arrays.asList(albumList);

                if (!albumArrayList.isEmpty()){

                    System.out.println("\n\n\n Albums Search Result for : "+searchTerm+"\n\n");

                    albumArrayList.stream().limit(4).forEach( album -> System.out.println(album.toAlbumString()));

                    System.out.println("\n\n ******************************************** \n\n\n");
                }
                System.exit(0);

            }else{
                System.out.println("\n\n\n Sorry !! this API is currently not supported : "+selectedApi+"\n\n\n");

                System.exit(0);
            }




    }
}
