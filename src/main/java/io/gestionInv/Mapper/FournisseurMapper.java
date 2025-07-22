package io.gestionInv.Mapper;

import io.gestionInv.DTO.FournisseurRequestDTO;
import io.gestionInv.Domaine.Fournisseur;
import org.springframework.stereotype.Component;

@Component
public class FournisseurMapper {

    public FournisseurRequestDTO toDTO(Fournisseur fournisseur) {
        FournisseurRequestDTO dto = new FournisseurRequestDTO();
        dto.setId(fournisseur.getId());
        dto.setNomfourni(fournisseur.getNomfourni());
        dto.setTelephonefourni(fournisseur.getTelephonefourni());
        dto.setAdressefourni(fournisseur.getAdressefourni());
        return dto;
    }

    public Fournisseur toDomain(FournisseurRequestDTO dto) {
        Fournisseur fournisseur = new Fournisseur();
        fournisseur.setId(dto.getId());
        fournisseur.setNomfourni(dto.getNomfourni());
        fournisseur.setTelephonefourni(dto.getTelephonefourni());
        fournisseur.setAdressefourni(dto.getAdressefourni());
        return fournisseur;
    }

}
