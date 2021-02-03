import { HttpClientModule } from '@angular/common/http';
import { ComponentFixture, TestBed } from '@angular/core/testing';
import { RouterTestingModule } from '@angular/router/testing';

import { MusicItemComponent } from './music-item.component';

describe('MusicItemComponent', () => {
  let component: MusicItemComponent;
  let fixture: ComponentFixture<MusicItemComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ MusicItemComponent ],
      imports: [RouterTestingModule, HttpClientModule]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(MusicItemComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
