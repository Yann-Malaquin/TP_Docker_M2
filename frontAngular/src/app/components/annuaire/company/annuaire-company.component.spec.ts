import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AnnuaireCompanyComponent } from './annuaire-company.component';

describe('AnnuaireCompanyComponent', () => {
  let component: AnnuaireCompanyComponent;
  let fixture: ComponentFixture<AnnuaireCompanyComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ AnnuaireCompanyComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(AnnuaireCompanyComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
