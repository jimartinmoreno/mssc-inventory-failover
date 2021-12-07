package guru.sfg.brewery.inventoryfailover.web;

import guru.sfg.brewery.inventoryfailover.model.BeerInventoryDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.OffsetDateTime;
import java.util.UUID;

@Slf4j
@RequiredArgsConstructor
@RestController
public class BeerInventoryController {

    @GetMapping("/inventory-failover")
    BeerInventoryDto inventoryFailover(){
        BeerInventoryDto dto = BeerInventoryDto.builder()
                .id(UUID.randomUUID())
                .beerId(UUID.fromString("00000000-0000-0000-0000-000000000000"))
                .quantityOnHand(999)
                .createdDate(OffsetDateTime.now())
                .lastModifiedDate(OffsetDateTime.now())
                .build();

        log.info("Finding Inventory for dto: " + dto);
        return dto;
    }
}
