import { Component, OnInit } from '@angular/core';
import { ServiceService } from 'src/app/Service/service.service';
import { Router } from '@angular/router';
import { Persona } from 'src/app/Model/persona';

@Component({
  selector: 'app-add',
  templateUrl: './add.component.html',
  styleUrls: ['./add.component.css']
})
export class AddComponent implements OnInit {

  persona: Persona = new Persona();

  constructor(private router:Router,private service: ServiceService) { }

  ngOnInit() {
  }

  Guardar(persona: Persona){

      this.service.addPersona(persona)
      .subscribe(data=>{
        this.persona=data;
        alert("Se agrego con exito");
        this.router.navigate(["listar"]);
      })
  }

}
