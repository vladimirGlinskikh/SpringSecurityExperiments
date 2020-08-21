package kz.zhelezyaka.springSecurity.rest;

import kz.zhelezyaka.springSecurity.model.Developer;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@RestController
@RequestMapping("/api/v1/developers")
public class DeveloperRestControllerV1 {
    private List<Developer> developers = Stream.of(
            new Developer(1L, "Vladimir", "Glinskikh"),
            new Developer(2L, "Alexandr", "Baglay"),
            new Developer(3L, "Dmitry", "Roy")
    ).collect(Collectors.toList());

    @GetMapping
    public List<Developer> getAll() {
        return developers;
    }

    @GetMapping("/{id}")
    @PreAuthorize("hasAuthority('developers:read')")
    public Developer getById(@PathVariable Long id) {
        return developers.stream().filter(developer -> developer.getId().equals(id))
                .findFirst()
                .orElse(null);
    }

    @PostMapping
    @PreAuthorize("hasAuthority('developers:write')")
    public Developer create(@RequestBody Developer developer) {
        this.developers.add(developer);
        return developer;
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasAuthority('developers:write')")
    public void deleteById(@PathVariable Long id) {
        this.developers.removeIf(developer -> developer.getId().equals(id));
    }
}
