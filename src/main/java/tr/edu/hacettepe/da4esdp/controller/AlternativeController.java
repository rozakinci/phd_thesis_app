package tr.edu.hacettepe.da4esdp.controller;

import org.springframework.web.bind.annotation.*;
import tr.edu.hacettepe.da4esdp.entity.Alternative;
import tr.edu.hacettepe.da4esdp.entity.Dto;
import tr.edu.hacettepe.da4esdp.repository.AlternativeRepository;
import tr.edu.hacettepe.da4esdp.service.FuzzyTopsis;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class AlternativeController {

    private final AlternativeRepository alternativeRepository;

    public AlternativeController(AlternativeRepository alternativeRepository) {
        this.alternativeRepository = alternativeRepository;
    }

    @GetMapping("/alternatives")
    public List<Alternative> getAlternatives() {
        return (List<Alternative>) alternativeRepository.findAll();
    }

    @PostMapping("/alternatives")
    void addAlternative(@RequestBody Alternative alternative) {
        alternativeRepository.save(alternative);
    }

    @PostMapping("/result")
    public List<Alternative> calculate(@RequestBody Dto dto) {
        FuzzyTopsis topsis = new FuzzyTopsis();
        return topsis.startFuzzyTopsisCalculation(dto.getCriteriaList()
                , dto.getAlternativeList());
    }
}
