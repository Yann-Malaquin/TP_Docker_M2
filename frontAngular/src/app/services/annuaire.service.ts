import {Injectable} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs';
import {Person} from '../models/person/person.model';
import {environment} from '../../environments/environment';
import {Company} from '../models/company/company.model';

@Injectable({
  providedIn: 'root'
})
export class AnnuaireService {

  constructor(private http: HttpClient) {
  }

  public getPersons(): Observable<Person[]> {
    return this.http.get<Person[]>(`${environment.url}/annuaireRest`);
  }

  public createPerson(person: Person): Observable<any> {
    return this.http.post(`${environment.url}/createPersonRest`, person);
  }

  public deletePerson(id?: number): Observable<any> {
    return this.http.delete(`${environment.url}/deletePersonRest/${id}`);
  }

  public getPerson(id?: number): Observable<any> {
    return this.http.get(`${environment.url}/annuaire/person/${id}`);
  }

  public updatePerson(person: Person, id?: number): Observable<any> {
    return this.http.put(`${environment.url}/annuaire/updatePerson/${id}`, person);
  }

  public getPersonsByName(name?: string): Observable<Person[]> {
    return this.http.get<Person[]>(`${environment.url}/annuaire/search/${name}`);
  }

  public getCompanies(): Observable<Company[]> {
    return this.http.get<Company[]>(`${environment.url}/annuaireCompany`);
  }

  public createCompany(company: Company): Observable<any> {
    return this.http.post(`${environment.url}/createCompany`, company);
  }

  public deleteCompany(id?: number): Observable<any> {
    return this.http.delete(`${environment.url}/deleteCompany/${id}`);
  }

  public getCompany(id?: number): Observable<any> {
    return this.http.get(`${environment.url}/annuaire/company/${id}`);
  }

  public updateCompany(company: Company, id?: number): Observable<any> {
    return this.http.put(`${environment.url}/annuaire/updateCompany/${id}`, company);
  }
}
