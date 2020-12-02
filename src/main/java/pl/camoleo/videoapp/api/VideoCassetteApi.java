package pl.camoleo.videoapp.api;

import org.springframework.web.bind.annotation.*;
import pl.camoleo.videoapp.DAO.entity.VideoCassette;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/cassetts")
public class VideoCassetteApi {

    private List<VideoCassette> videoCassettes;

//    public VideoCassetteApi() {
//        videoCassettes = new ArrayList<>();
//        videoCassettes.add(new VideoCassette(1L, "Kevin alone in New York", LocalDate.of(1961, 1, 5)));
//        videoCassettes.add(new VideoCassette(2L, "Bridget Jones", LocalDate.of(1978, 8, 28)));
//
//    }

    @GetMapping("/all")
    public List<VideoCassette> getAll() {
        return videoCassettes;
    }

    @GetMapping
    public VideoCassette getById(@RequestParam int index) {
        Optional<VideoCassette> first = videoCassettes.stream().
                filter(element -> element.getId() == index).findFirst();
        return first.get();
    }

    @PostMapping //- dodawanie nowych elementów
    public boolean addVideoCassette(@RequestBody VideoCassette videoCassette){
        return videoCassettes.add(videoCassette);
    }

    @PutMapping //-nadpisywanie elementów
    public boolean updateVideoList(@RequestBody VideoCassette videoCassette){
        return videoCassettes.add(videoCassette);
    }

    @DeleteMapping
    public boolean deleteVideoCassette(@RequestParam int index){
        return videoCassettes.removeIf(element -> element.getId() == index);
    }
}
