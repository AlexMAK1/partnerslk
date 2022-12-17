package ru.planetnails.partnerslk.model.item.Dto;

import lombok.*;
import ru.planetnails.partnerslk.model.item.StatusItem;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder

public class ItemAddDto {
    @NotBlank
    private String id;
    @NotBlank
    private String name;

    private String description;

    private String vendorCode;

    private String descriptionHtml;

    private Boolean isGroup;

    private String parent_id;

    private Integer level;

    private String countryOfOrigin;

    private Boolean isOutOfStock;

    @Override
    public String toString() {
        return "ItemAddDto{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", isGroup=" + isGroup +
                ", parent_id='" + parent_id + '\'' +
                '}';
    }
}
