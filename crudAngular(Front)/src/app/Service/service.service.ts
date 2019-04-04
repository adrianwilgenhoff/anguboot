import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Persona } from '../Model/persona';

@Injectable({
  providedIn: 'root'
})
export class ServiceService {
  

  constructor(private http:HttpClient) { }

  Url='http://localhost:8080/personas';
  
  getPersonas(){ 
    return this.http.get<Persona[]>(this.Url);
  }

  addPersona(persona:Persona){
    return this.http.post<Persona>(this.Url,persona);
  }

  getPersonaId(id:number){

    return this.http.get<Persona>(this.Url+"/"+id);
  }

  updatePesona(persona:Persona){
    return this.http.put<Persona>(this.Url+"/"+persona.id,persona);
  }

  deletePersona(persona:Persona){
    return this.http.delete<Persona>(this.Url+"/"+persona.id);
  }
}
