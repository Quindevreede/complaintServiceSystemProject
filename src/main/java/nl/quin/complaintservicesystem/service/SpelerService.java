package nl.quin.complaintservicesystem.service;

import nl.quin.complaintservicesystem.exceptions.RecordNotFoundException;
import nl.quin.complaintservicesystem.model.Speler;
import nl.quin.complaintservicesystem.repository.SpelerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class SpelerService {

    private final SpelerRepository spelerRepository;

    @Autowired
    public SpelerService(SpelerRepository spelerRepository) {
        this.spelerRepository = spelerRepository;
    }

    public Iterable<Speler> findAll() {
        Iterable<Speler> spelers = spelerRepository.findAll();
        return spelers;
    }

    public Speler findById(long nr) {
        Optional<Speler> speler = spelerRepository.findById(nr);
        if (speler.isPresent()) {
            return speler.get();
        }
        else {
            throw new RecordNotFoundException("Speler with id " + nr + " not found");
        }
    }

    public void save(Speler speler) {
        spelerRepository.save(speler);
    }

    public void deleteById(long nr) {
        try {
            spelerRepository.deleteById(nr);
        }
        catch (IndexOutOfBoundsException ex) {
            System.out.println(ex);
            throw new RecordNotFoundException();
        }
    }

}
