package co.com.meli.jpa.entities;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import javax.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Cacheable(value = false)
@Table(name = "auditismutant")
@Getter
@Setter
public class AuditoriaMutanteEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id")
  private Long id;

  @Column(name = "ismutant")
  private Long ismutant;

  @Column(name = "dna")
  private String dna;

  @JsonFormat(pattern = "dd-MM-yyyy HH:mm", timezone = "America/Bogota")
  @Column(name = "date")
  private Date date;
}
