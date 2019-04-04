import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { ServiceService } from 'src/app/Service/service.service';
import { Persona } from 'src/app/Model/Persona'

@Component({
  selector: 'app-edit',
  templateUrl: './edit.component.html',
  styleUrls: ['./edit.component.css']
})
export class EditComponent implements OnInit {

  persona: Persona = new Persona();
  constructor(private router: Router, private service: ServiceService) { }


  ngOnInit() {
    this.Editar();
  }

  Editar() {
    let id = localStorage.getItem("id");
    this.service.getPersonaId(+id)
      .subscribe(data => {
        this.persona = data;
      })
  }

  Actualizar(persona:Persona){
    this.service.updatePesona(persona)
    .subscribe(data=>{
      this.persona=data;
      alert("Se actualizado con exito")
      this.router.navigate(["listar"])
    })

  }

}
