package com.example.petproject.controller;

import com.example.petproject.entity.Owner;
import com.example.petproject.entity.Pet;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/v1/owners")
public class OwnerController {

    private static List<Owner> owners = new ArrayList<>();

    private static List<Pet> pets = new ArrayList<>();

    private static int nextOwnerId = 1;


    // =========================
    // 9. Thêm owner
    // POST /api/v1/owners
    // =========================

    @PostMapping
    public Owner createOwner(@RequestBody Owner request) {

        Owner owner = new Owner();

        owner.setId(nextOwnerId++);
        owner.setName(request.getName());
        owner.setPhone(request.getPhone());
        owner.setEmail(request.getEmail());

        owners.add(owner);

        return owner;
    }


    // =========================
    // 10. Lấy danh sách owner
    // GET /api/v1/owners
    // =========================

    @GetMapping
    public List<Owner> getAllOwners() {

        return owners;
    }


    // =========================
    // 11. Lấy owner theo ID
    // GET /api/v1/owners/{id}
    // =========================

    @GetMapping("/{id}")
    public Owner getOwnerById(@PathVariable int id) {

        for (Owner owner : owners) {

            if (owner.getId() == id) {
                return owner;
            }
        }

        return null;
    }


    // =========================
    // 12. Cập nhật owner
    // PUT /api/v1/owners/{id}
    // =========================

    @PutMapping("/{id}")
    public Owner updateOwner(
            @PathVariable int id,
            @RequestBody Owner request) {

        for (Owner owner : owners) {

            if (owner.getId() == id) {

                owner.setName(request.getName());
                owner.setPhone(request.getPhone());
                owner.setEmail(request.getEmail());

                return owner;
            }
        }

        return null;
    }


    // =========================
    // 13. Xóa owner
    // DELETE /api/v1/owners/{id}
    // =========================

    @DeleteMapping("/{id}")
    public String deleteOwner(@PathVariable int id) {

        for (Owner owner : owners) {

            if (owner.getId() == id) {

                owners.remove(owner);

                return "Delete owner successfully";
            }
        }

        return "Owner not found";
    }


    // =========================
    // 14. Lấy pet của owner
    // GET /api/v1/owners/{ownerId}/pets
    // =========================

    @GetMapping("/{ownerId}/pets")
    public List<Pet> getPetsByOwner(
            @PathVariable int ownerId) {

        return new ArrayList<>();
    }
}