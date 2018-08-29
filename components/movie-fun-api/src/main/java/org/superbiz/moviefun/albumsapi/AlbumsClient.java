package org.superbiz.moviefun.albumsapi;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.web.client.RestOperations;
import org.superbiz.moviefun.blobstore.BlobStore;

import java.util.List;

import static org.springframework.http.HttpMethod.GET;

public class AlbumsClient {

    private String albumsUrl;
    private RestOperations restOperations;


    private static ParameterizedTypeReference<List<AlbumInfo>> albumListType = new ParameterizedTypeReference<List<AlbumInfo>>() {
    };

    public AlbumsClient(String albumsUrl, RestOperations restOperations) {
        this.albumsUrl = albumsUrl;
        this.restOperations = restOperations;
    }

    public void addAlbum(AlbumInfo albumInfo) {
        restOperations.postForEntity(albumsUrl, albumInfo, AlbumInfo.class);
    }


        public List<AlbumInfo> getAlbums() {
        return restOperations.exchange(albumsUrl, GET, null, albumListType).getBody();
    }

    public AlbumInfo find(long albumId) {
        return restOperations.getForEntity(albumsUrl + "/" + albumId, AlbumInfo.class).getBody();
    }

}
