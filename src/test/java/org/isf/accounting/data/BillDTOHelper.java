package org.isf.accounting.data;

import java.util.List;

import org.isf.accounting.dto.BillDTO;
import org.isf.patient.dto.PatientDTO;
import org.isf.patient.mapper.PatientMapper;
import org.isf.patient.model.Patient;
import org.isf.patient.test.TestPatient;
import org.isf.utils.exception.OHException;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class BillDTOHelper{
	public static BillDTO setup(PatientMapper patientMapper) throws OHException{
		Patient patient = new TestPatient().setup(true);
		PatientDTO patientDTO = patientMapper.map2DTO(patient);
		BillDTO billDTO = new BillDTO();
		billDTO.setPatientDTO(patientDTO);
		return billDTO;
	}
	
	public static BillDTO setup(Integer id, PatientMapper patientMapper) throws OHException {
		BillDTO billDTO = BillDTOHelper.setup(patientMapper);
		billDTO.setId(id);
		return billDTO;
	}

	public static String asJsonString(BillDTO billDTO){
		try {
			return new ObjectMapper().writeValueAsString(billDTO);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public static String asJsonString(List<BillDTO> billDTOList){
		try {
			return new ObjectMapper().writeValueAsString(billDTOList);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		return null;
	}
}