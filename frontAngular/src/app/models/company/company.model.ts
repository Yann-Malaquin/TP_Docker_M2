import {Person} from '../person/person.model';

export class Company {
  id?:number;
  name: string | undefined;
  phone: string | undefined;
  address: string | undefined;
  city: string | undefined;
  country: string | undefined;
  personRestList?: Person[];
}
