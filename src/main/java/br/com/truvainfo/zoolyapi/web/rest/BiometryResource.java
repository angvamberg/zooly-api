package br.com.truvainfo.zoolyapi.web.rest;

import br.com.truvainfo.zoolyapi.domain.dto.BiometryDto;
import br.com.truvainfo.zoolyapi.service.BiometryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.HttpStatus.*;

@RestController
@RequestMapping("/biometry")
@RequiredArgsConstructor
public class BiometryResource {
	
	private final BiometryService biometryService;
	
	@GetMapping(value = "/{animalId}", produces = "application/json")
	public ResponseEntity<List<BiometryDto>> findAnimalBiometrics(@PathVariable final Integer animalId) {
		return ResponseEntity.ok(biometryService.findAnimalBiometrics(animalId));
	}
	
	@PostMapping(consumes = "application/json")
	public ResponseEntity<BiometryDto> saveBiometry(@RequestBody final BiometryDto biometryDto) {
		
		biometryService.saveBiometry(biometryDto);
		return ResponseEntity.status(CREATED).build();
	}
	
	@PutMapping(consumes = "application/json")
	public ResponseEntity<BiometryDto> updateBiometry(@RequestBody final BiometryDto biometryDto) {
		
		biometryService.saveBiometry(biometryDto);
		return ResponseEntity.status(NO_CONTENT).build();
	}
	
	@DeleteMapping("/{biometryId}")
	public ResponseEntity<BiometryDto> deleteBiometry(@PathVariable final Integer biometryId) {
		
		biometryService.deleteBiometry(biometryId);
		return ResponseEntity.status(NO_CONTENT).build();
	}
}
