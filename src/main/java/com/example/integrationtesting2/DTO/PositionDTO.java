package com.example.integrationtesting2.DTO;

import com.example.integrationtesting2.pojo.Position;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class PositionDTO {
    private Integer id;

    private String name;

    public static PositionDTO fromPosition(Position position) {
        PositionDTO positionDTO = new PositionDTO();
        positionDTO.setId(position.getId());
        positionDTO.setName(position.getName());
        return positionDTO;
    }

    public Position toPosition() {
        Position position = new Position();
        position.setId(this.getId());
        position.setName(this.getName());
        return position;
    }

    @Override
    public String toString() {
        return "PositionDTO{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
