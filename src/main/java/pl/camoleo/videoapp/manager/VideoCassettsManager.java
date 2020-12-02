package pl.camoleo.videoapp.manager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;
import pl.camoleo.videoapp.DAO.VideoCassetteRepo;
import pl.camoleo.videoapp.DAO.entity.VideoCassette;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Optional;

@Service
public class VideoCassettsManager {

    private VideoCassetteRepo videoCassetteRepo;

    @Autowired
    public VideoCassettsManager(VideoCassetteRepo videoCassetteRepo) {
        this.videoCassetteRepo = videoCassetteRepo;
    }

    public Optional<VideoCassette> findById(Long id) {
        return videoCassetteRepo.findById(id);
    }

    public Iterable<VideoCassette> findAll() {
        return videoCassetteRepo.findAll();
    }

    public VideoCassette save(VideoCassette videoCassette) {
        return videoCassetteRepo.save(videoCassette);
    }

    public void delete(Long id) {
        videoCassetteRepo.deleteById(id);
    }

    @EventListener(ApplicationReadyEvent.class) //-ta metoda wykona się w momencie uruchomienia aplikacji
    public void fillDB() {
        save(new VideoCassette(1L, "Kevin alone in New York", LocalDate.of(1961, 1, 5)));
        save(new VideoCassette(2L, "Bridget Jones", LocalDate.of(1978, 8, 28)));

    }
}
