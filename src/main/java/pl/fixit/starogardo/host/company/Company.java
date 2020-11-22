package pl.fixit.starogardo.host.company;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "COMPANY")
public class Company {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private long id;

    private String name;

    private String phoneNumber;

    @OneToOne
    @JoinColumn(name = "category_id", referencedColumnName = "id")
    private CompanyCategory companyCategory;

    @OneToMany(cascade=CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn (name = "subCategories_id", referencedColumnName = "id")
    private List<SubCategories> subcatogories;

    private String description;

    @Lob
    private byte[] storePicture;

    private String adresss;

    private String nip;

    private String accountNumber;

    private String email;
}
