package pl.krzysztofskul.organization.hospital.department.departmentCategory;

import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pl.krzysztofskul.organization.hospital.medicalFunctionTag.MedicalFunctionTag;
import pl.krzysztofskul.organization.hospital.medicalFunctionTag.MedicalFunctionTagEnum;
import pl.krzysztofskul.organization.hospital.medicalFunctionTag.MedicalFunctionTagService;

import java.util.List;

@Service
@Transactional
public class DepartmentCategoryService {

    private DepartmentCategoryRepo departmentCategoryRepo;
    private MedicalFunctionTagService medicalFunctionTagService;

    @Autowired
    public DepartmentCategoryService(
    		DepartmentCategoryRepo departmentCategoryRepo,
    		MedicalFunctionTagService medicalFunctionTagService
    		) {
        this.departmentCategoryRepo = departmentCategoryRepo;
        this.medicalFunctionTagService = medicalFunctionTagService;
    }

    public void save(DepartmentCategory departmentCategory) {
        departmentCategoryRepo.save(departmentCategory);
    }

    public List<DepartmentCategory> loadAll() {
        List<DepartmentCategory> departmentCategoryList = departmentCategoryRepo.findAll();
        for (DepartmentCategory departmentCategory : departmentCategoryList) {
            Hibernate.initialize(departmentCategory.getMedicalFunctionTagList());
        }
        return departmentCategoryList;
    }

    public DepartmentCategory loadById(Long id) {
        return departmentCategoryRepo.findById(id).get();
    }
    
    public DepartmentCategory loadByIdWithMedicalFunctionTags(Long id) {
        DepartmentCategory departmentCategory = this.loadById(id);
        Hibernate.initialize(departmentCategory.getMedicalFunctionTagList());
    	return departmentCategory;
    }

    public DepartmentCategory loadByCode(String code) {
        return departmentCategoryRepo.findByCode(code);
    }

    public void delete(DepartmentCategory departmentCategory) {
        departmentCategoryRepo.delete(departmentCategory);
    }
    
	public void addMedicalFunctionTagAndSaveDepartmentCategory(Long departmentId, MedicalFunctionTag medicalFunctionTag) {
				
		DepartmentCategory departmentCategory = null;
		MedicalFunctionTag medicalFunctionTagAdditional = null;
		
		if (null != departmentId) {
			departmentCategory = this.loadByIdWithMedicalFunctionTags(departmentId);			

			
	    	if (null != medicalFunctionTag & !departmentCategory.getMedicalFunctionTagList().contains(medicalFunctionTag)) {
				departmentCategory.addMedicalFunctionTag(medicalFunctionTag);	    		
		    	if (
		    			medicalFunctionTag.getMedicalFunctionTagEnum().equals(MedicalFunctionTagEnum.CONSULTATIONS)
		    			||
		    			medicalFunctionTag.getMedicalFunctionTagEnum().equals(MedicalFunctionTagEnum.DIAGNOSTICS)
		    			||
		    			medicalFunctionTag.getMedicalFunctionTagEnum().equals(MedicalFunctionTagEnum.DIAGNOSTICS_AND_OPERATIONS)
		    			||
		    			medicalFunctionTag.getMedicalFunctionTagEnum().equals(MedicalFunctionTagEnum.STANDARD_CARE)
		    			||
		    			medicalFunctionTag.getMedicalFunctionTagEnum().equals(MedicalFunctionTagEnum.INTENSIVE_CARE)
		    			||
		    			medicalFunctionTag.getMedicalFunctionTagEnum().equals(MedicalFunctionTagEnum.OPERATIONS)
		    			||
		    			medicalFunctionTag.getMedicalFunctionTagEnum().equals(MedicalFunctionTagEnum.SURGERY)
					) {
		    		medicalFunctionTagAdditional = medicalFunctionTagService.loadByNameEN("MEDICAL");
		    		departmentCategory.addMedicalFunctionTag(medicalFunctionTagAdditional);
		    	}
	    		
		    	this.save(departmentCategory);
	    	}
	    	
		}
	}

}
