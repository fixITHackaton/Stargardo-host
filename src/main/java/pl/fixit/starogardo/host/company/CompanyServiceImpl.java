package pl.fixit.starogardo.host.company;

import pl.fixit.stargardo.common.company.dto.CompanyDto;
import pl.fixit.stargardo.common.company.dto.CompanySubcategoryDto;
import pl.fixit.stargardo.common.company.enums.CompanyCategory;
import pl.fixit.stargardo.common.company.restaurant.dto.CompanySearchCriteriaDto;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.Arrays;
import java.util.List;

public abstract class CompanyServiceImpl implements CompanyService {

    @PersistenceContext
    private EntityManager em;

    public List<CompanyDto> getCompaniesFromDB(CompanySearchCriteriaDto searchCriteriaDto) {
        TypedQuery query = em.createQuery("select a from Company a where a.companyCategory.id=?1", Company.class);;
        if (searchCriteriaDto.getCompanyCategory()!= null && searchCriteriaDto.getSubcategoryId() == null && searchCriteriaDto.getText() == null){
            //TODO query = em.createQuery("select a from Company a where a.companyCategory=?1", Company.class);
        }else if (searchCriteriaDto.getCompanyCategory()== null && searchCriteriaDto.getSubcategoryId() != null && searchCriteriaDto.getText() == null){
            //TODO query = em.createQuery("select a from Company a where a.subcatogories = ?2", Company.class);
        }else if (searchCriteriaDto.getCompanyCategory()!= null && searchCriteriaDto.getSubcategoryId() == null && searchCriteriaDto.getText() == null){
            //TODO
        }else if (searchCriteriaDto.getCompanyCategory()== null && searchCriteriaDto.getSubcategoryId() == null && searchCriteriaDto.getText() != null){
            //TODO query = em.createQuery("select a from Company a where a.name=?4", Company.class);
        }


        query.setParameter(1, ((long) searchCriteriaDto.getCompanyCategory().ordinal()+1));
        //TODO
//        query.setParameter(2, searchCriteriaDto.getCompanyCategory());
//        query.setParameter(3, searchCriteriaDto.getCompanyCategory());
//        query.setParameter(4, searchCriteriaDto.getText());

        return query.getResultList();
    }

    public List<CompanySubcategoryDto> findSubcategories(CompanyCategory companyCategory) {
        TypedQuery query = em.createQuery("select a from SubCategories a where a.companyCategory = ?1", SubCategories.class);
        query.setParameter(1, companyCategory);
        return query.getResultList();
    }

    public CompanyCategory getCompanyCategory(Long companyId) {
        return CompanyCategory.FOOD;
    }
}
