package io.gestionInv.Mapper;

import io.gestionInv.DTO.FournisseurRequestDTO;
import io.gestionInv.Domaine.Fournisseur;
import io.gestionInv.Persistance.FournisseurJPAEntity;
import org.springframework.stereotype.Component;

@Component
public class FournisseurMapper {
    // DTO → Domaine
    public FournisseurRequestDTO toDTO(Fournisseur fournisseur) {
        FournisseurRequestDTO dto = new FournisseurRequestDTO();
        dto.setId(fournisseur.getId());
        dto.setNomfourni(fournisseur.getNomfourni());
        dto.setTelephonefourni(fournisseur.getTelephonefourni());
        dto.setAdressefourni(fournisseur.getAdressefourni());
        return dto;
    }
    // Domaine → DTO
    public Fournisseur toDomain(FournisseurRequestDTO dto) {
        Fournisseur fournisseur = new Fournisseur();
        fournisseur.setId(dto.getId());
        fournisseur.setNomfourni(dto.getNomfourni());
        fournisseur.setTelephonefourni(dto.getTelephonefourni());
        fournisseur.setAdressefourni(dto.getAdressefourni());
        return fournisseur;
    }
    // Domaine → JPA Entity
    public FournisseurJPAEntity toEntity(Fournisseur fournisseur) {
        FournisseurJPAEntity entity = new FournisseurJPAEntity();
        entity.setId(fournisseur.getId());
        entity.setNomfourni(fournisseur.getNomfourni());
        entity.setTelephonefourni(fournisseur.getTelephonefourni());
        entity.setAdressefourni(fournisseur.getAdressefourni());
        return entity;
    }

    // JPA Entity → Domaine
    public Fournisseur toDomain(FournisseurJPAEntity entity) {
        Fournisseur fournisseur = new Fournisseur();
        fournisseur.setId(entity.getId());
        fournisseur.setNomfourni(entity.getNomfourni());
        fournisseur.setTelephonefourni(entity.getTelephonefourni());
        fournisseur.setAdressefourni(entity.getAdressefourni());
        return fournisseur;
    }

}
