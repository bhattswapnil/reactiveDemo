package com.example.demo.medication.service

import com.example.demo.Reference
import com.example.demo.medication.model.DTDMedicationStatement
import com.example.demo.medication.repository.MedicationRepository
import com.example.demo.person.model.PersonDTO
import org.bson.types.ObjectId
import org.springframework.stereotype.Service

@Service
class MedicationServiceImpl(
        private val medicationRepository: MedicationRepository,
        private var referencePerson: Reference<PersonDTO>
):MedicationService {

    override fun getResources(): List<DTDMedicationStatement> {
        return medicationRepository.findAll()
    }

    override fun createResource(Medication: DTDMedicationStatement): DTDMedicationStatement {
        val id: String = ObjectId().toString();
        toReference(Medication);
        return medicationRepository.save(DTDMedicationStatement(
                id = id,
                status = Medication.status,
                subject = referencePerson,
                dosage = Medication.dosage
        ))
    }

    override fun updateResource(request: DTDMedicationStatement, id: String): DTDMedicationStatement {
        val medication = medicationRepository.findOneById(id)
        toReference(request);
        return medicationRepository.save(DTDMedicationStatement(
                id = id,
                status = request.status,
                subject = referencePerson,
                dosage = request.dosage
        ))
    }


    fun toReference(Medication: DTDMedicationStatement) {
        val personIdentifier = Medication.subject?.identifier;
        val personId = Medication.subject?.identifier?.value;
        val type = Medication.subject?.type;
        referencePerson.identifier = personIdentifier;
        referencePerson.type = type;
        referencePerson.reference = "/person/${personId}";
    }
}