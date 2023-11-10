import { TestBed } from '@angular/core/testing';

import { BearerTokenInterceptorService } from './bearer-token-interceptor.service';

describe('BearerTokenInterceptorService', () => {
  let service: BearerTokenInterceptorService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(BearerTokenInterceptorService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
