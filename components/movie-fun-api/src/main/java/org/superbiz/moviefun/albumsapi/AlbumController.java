package org.superbiz.moviefun.albumsapi;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Map;

@Controller
public class AlbumController {

    AlbumsClient albumsClient;

    public AlbumController(AlbumsClient albumsClient) {
        this.albumsClient = albumsClient;
    }

    @GetMapping
    public String index(Map<String, Object> model) {
        model.put("albums", albumsClient.getAlbums());
        return "albums";
    }
}
