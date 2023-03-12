package co.com.meli.jpa.entities;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import javax.persistence.*;
import lombok.*;

@Entity
@Cacheable(value = false)
@Table(name = "auditismutant")
@Getter
@Setter
@Builder
@RequiredArgsConstructor
@AllArgsConstructor
public class AuditoriaMutanteEntity {

  @Id
  @Column(name = "id")
  private String id;

  @Column(name = "ismutant")
  private int ismutant;

  @Column(name = "dna")
  private String dna;

  @Column(name = "combinaciones")
  private String combinaciones;

  @JsonFormat(pattern = "dd-MM-yyyy HH:mm", timezone = "America/Bogota")
  @Column(name = "date")
  private Date date;
}
