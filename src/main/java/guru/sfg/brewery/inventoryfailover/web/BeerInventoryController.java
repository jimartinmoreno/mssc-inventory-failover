package guru.sfg.brewery.inventoryfailover.web;

import guru.sfg.brewery.inventoryfailover.model.BeerInventoryDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.OffsetDateTime;
import java.util.List;
import java.util.UUID;

@Slf4j
@RequiredArgsConstructor
@RestController
public class BeerInventoryController {

    @GetMapping("/inventory-failover")
    public ResponseEntity<List<BeerInventoryDto>> inventoryFailover(){
        List<BeerInventoryDto> beerInventoryDtoList = List.of(BeerInventoryDto.builder()
                .id(UUID.randomUUID())
                .beerId(UUID.fromString("00000000-0000-0000-0000-000000000000"))
                .quantityOnHand(999)
                .createdDate(OffsetDateTime.now())
                .lastModifiedDate(OffsetDateTime.now())
                .build());

        log.info("Finding Inventory for dto: " + beerInventoryDtoList);
        return new ResponseEntity<>(beerInventoryDtoList, HttpStatus.OK);
    }
}
