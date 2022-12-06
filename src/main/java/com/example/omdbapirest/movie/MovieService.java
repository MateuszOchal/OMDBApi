package com.example.omdbapirest.movie;

import lombok.RequiredArgsConstructor;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import org.json.simple.parser.ParseException;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.List;

@Service
@RequiredArgsConstructor
public class MovieService {
    private final MovieRepository repository;

    public String getJSONFromURL(String strUrl) {
        String jsonText = "";

        try {
            URL url = new URL(strUrl);
            InputStream is = url.openStream();

            BufferedReader bufferedReader =
                    new BufferedReader(new InputStreamReader(is));

            String line;
            while ((line = bufferedReader.readLine()) != null) {
                jsonText += line + "\n";
            }

            is.close();
            bufferedReader.close();
        } catch (Exception e) {
            e.printStackTrace();
        }


        return jsonText;
    }

    public Movie getDataFromOMDBAsMovie(String strURL) {
        String json = getJSONFromURL("https://www.omdbapi.com/?t=" + strURL + "&apikey=30ccf40c");

        Movie movie = new Movie();
        JSONParser parser = new JSONParser();
        Object object = null;
        try {
            object = parser.parse(json);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
        JSONObject mainJsonObject = (JSONObject) object;
        String title = (String) mainJsonObject.get("Title");
        movie.setTitle(title);
        String plot = (String) mainJsonObject.get("Plot");
        movie.setPlot(plot);
        String genre = (String) mainJsonObject.get("Genre");
        movie.setGenre(genre);
        String director = (String) mainJsonObject.get("Director");
        movie.setDirector(director);
        String posterURL = (String) mainJsonObject.get("Poster");
        movie.setPosterURL(posterURL);
        repository.save(movie);
        return movie;
    }
}
