package com.example.reacitvespring.reacitvespring.medication.service

import com.example.reacitvespring.reacitvespring.DTDMedicationStatement
import com.example.reacitvespring.reacitvespring.Reference
import com.example.reacitvespring.reacitvespring.medication.repository.MedicationRepository
import com.example.reacitvespring.reacitvespring.medication.service.MedicationService
import com.example.reacitvespring.reacitvespring.person.model.PersonDTO
import org.bson.types.ObjectId
import org.springframework.stereotype.Service
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono

@Service
class MedicationServiceImpl(
        private val medicationRepository: MedicationRepository,
        private var referencePerson: Reference<PersonDTO>
): MedicationService {

    override fun readResource(id: String): Mono<DTDMedicationStatement> {
        return medicationRepository.findOneById(id)
    }

    override fun createResource(Medication: DTDMedicationStatement): Mono<DTDMedicationStatement> {
        val id: String = ObjectId().toString();
        toReference(Medication);
        return medicationRepository.save(DTDMedicationStatement(
                id = id,
                status = Medication.status,
                subject = referencePerson,
                dosage = Medication.dosage
        ))
    }

    override fun findAll(): Flux<DTDMedicationStatement> {
      return medicationRepository.findAll()
    }

    /* override fun updateResource(request: DTDMedicationStatement, id: String): DTDMedicationStatement {
         val medication = medicationRepository.findOneById(id)
         toReference(request);
         return medicationRepository.save(DTDMedicationStatement(
                 id = id,
                 status = request.status,
                 subject = referencePerson,
                 dosage = request.dosage
         ))
     }*/


    fun toReference(Medication: DTDMedicationStatement) {
        val personId = Medication.subject?.identifier?.value;
        referencePerson.identifier = Medication.subject?.identifier;
        referencePerson.type =Medication.subject?.type;
        referencePerson.reference = "/person/${personId}";
    }
}