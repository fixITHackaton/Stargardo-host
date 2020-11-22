package pl.fixit.starogardo.host.company;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.fixit.starogardo.host.company.Company;

public interface CompanyRepository extends JpaRepository<Company,Long> {
}
