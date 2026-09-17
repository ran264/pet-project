package com.example.petproject.controller;

import com.example.petproject.dto.CreatePetRequest;
import com.example.petproject.dto.UpdatePetRequest;
import com.example.petproject.entity.Pet;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/v1/pets")
public class PetController {

    private static List<Pet> pets = new ArrayList<>();

    private static int nextId = 1;

    // =========================
    // 1. Thêm pet
    // POST /api/v1/pets
    // =========================

    @PostMapping
    public Pet createPet(@RequestBody CreatePetRequest request) {

        Pet pet = new Pet();

        pet.setId(nextId++);
        pet.setName(request.getName());
        pet.setAge(request.getAge());
        pet.setSpecies(request.getSpecies());

        pets.add(pet);

        return pet;
    }


    // =========================
    // 2. Lấy danh sách pet
    // GET /api/v1/pets
    // =========================

    @GetMapping
    public List<Pet> getAllPets() {

        return pets;
    }


    // =========================
    // 3. Lấy pet theo ID
    // GET /api/v1/pets/{id}
    // =========================

    @GetMapping("/{id}")
    public Pet getPetById(@PathVariable int id) {

        for (Pet pet : pets) {

            if (pet.getId() == id) {
                return pet;
            }
        }

        return null;
    }


    // =========================
    // 4. Cập nhật toàn bộ pet
    // PUT /api/v1/pets/{id}
    // =========================

    @PutMapping("/{id}")
    public Pet updatePet(
            @PathVariable int id,
            @RequestBody UpdatePetRequest request) {

        for (Pet pet : pets) {

            if (pet.getId() == id) {

                pet.setName(request.getName());
                pet.setAge(request.getAge());
                pet.setSpecies(request.getSpecies());

                return pet;
            }
        }

        return null;
    }


    // =========================
    // 5. Cập nhật một phần
    // PATCH /api/v1/pets/{id}
    // =========================

    @PatchMapping("/{id}")
    public Pet patchPet(
            @PathVariable int id,
            @RequestBody UpdatePetRequest request) {

        for (Pet pet : pets) {

            if (pet.getId() == id) {

                if (request.getName() != null) {
                    pet.setName(request.getName());
                }

                if (request.getAge() != 0) {
                    pet.setAge(request.getAge());
                }

                if (request.getSpecies() != null) {
                    pet.setSpecies(request.getSpecies());
                }

                return pet;
            }
        }

        return null;
    }


    // =========================
    // 6. Xóa pet
    // DELETE /api/v1/pets/{id}
    // =========================

    @DeleteMapping("/{id}")
    public String deletePet(@PathVariable int id) {

        for (Pet pet : pets) {

            if (pet.getId() == id) {

                pets.remove(pet);

                return "Delete pet successfully";
            }
        }

        return "Pet not found";
    }


    // =========================
    // 7. Tìm pet theo tên
    // GET /api/v1/pets/search/name?name=Milu
    // =========================

    @GetMapping("/search/name")
    public List<Pet> searchByName(
            @RequestParam String name) {

        List<Pet> result = new ArrayList<>();

        for (Pet pet : pets) {

            if (pet.getName().equalsIgnoreCase(name)) {

                result.add(pet);
            }
        }

        return result;
    }


    // =========================
    // 8. Tìm pet theo loài
    // GET /api/v1/pets/search/species?species=Dog
    // =========================

    @GetMapping("/search/species")
    public List<Pet> searchBySpecies(
            @RequestParam String species) {

        List<Pet> result = new ArrayList<>();

        for (Pet pet : pets) {

            if (pet.getSpecies().equalsIgnoreCase(species)) {

                result.add(pet);
            }
        }

        return result;
    }
}