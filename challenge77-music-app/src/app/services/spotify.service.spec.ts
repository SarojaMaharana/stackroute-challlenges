import { HttpClientModule } from '@angular/common/http';
import { HttpClientTestingModule, HttpTestingController } from '@angular/common/http/testing'
import { TestBed } from '@angular/core/testing';

import { SpotifyService } from './spotify.service';

describe('SpotifyService', () => {
  let service: SpotifyService;
  let httpTestController: HttpTestingController;

  beforeEach(() => {
    TestBed.configureTestingModule({
      imports: [HttpClientModule, HttpClientTestingModule],
      providers: [SpotifyService]
    });
    service = TestBed.inject(SpotifyService);
  });

  beforeEach(() => {
    httpTestController = TestBed.inject(HttpTestingController);
  });

  afterEach(() => {
    httpTestController.verify();
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });

  it('should test get New Releases method', () => {
    const testData: Object = 
    {
      "albums": {
          "href": "https://api.spotify.com/v1/browse/new-releases?country=IN&offset=0&limit=20",
          "items": [
              {
                  "album_type": "single",
                  "artists": [
                      {
                          "external_urls": {
                              "spotify": "https://open.spotify.com/artist/1uNFoZAHBGtllmzznpCI3s"
                          },
                          "href": "https://api.spotify.com/v1/artists/1uNFoZAHBGtllmzznpCI3s",
                          "id": "1uNFoZAHBGtllmzznpCI3s",
                          "name": "Justin Bieber",
                          "type": "artist",
                          "uri": "spotify:artist:1uNFoZAHBGtllmzznpCI3s"
                      },
                      {
                          "external_urls": {
                              "spotify": "https://open.spotify.com/artist/1anyVhU62p31KFi8MEzkbf"
                          },
                          "href": "https://api.spotify.com/v1/artists/1anyVhU62p31KFi8MEzkbf",
                          "id": "1anyVhU62p31KFi8MEzkbf",
                          "name": "Chance the Rapper",
                          "type": "artist",
                          "uri": "spotify:artist:1anyVhU62p31KFi8MEzkbf"
                      }
                  ],
                  "available_markets": [
                      "AD",
                      "AE",
                      "AL",
                      "AR",
                      "AT",
                      "AU",
                      "BA",
                      "BE",
                      "BG",
                      "BH",
                      "BO",
                      "BR",
                      "BY",
                      "CA",
                      "CH",
                      "CL",
                      "CO",
                      "CR",
                      "CY",
                      "CZ",
                      "DE",
                      "DK",
                      "DO",
                      "DZ",
                      "EC",
                      "EE",
                      "EG",
                      "ES",
                      "FI",
                      "FR",
                      "GB",
                      "GR",
                      "GT",
                      "HK",
                      "HN",
                      "HR",
                      "HU",
                      "ID",
                      "IE",
                      "IL",
                      "IN",
                      "IS",
                      "IT",
                      "JO",
                      "JP",
                      "KW",
                      "KZ",
                      "LB",
                      "LI",
                      "LT",
                      "LU",
                      "LV",
                      "MA",
                      "MC",
                      "MD",
                      "ME",
                      "MK",
                      "MT",
                      "MX",
                      "MY",
                      "NI",
                      "NL",
                      "NO",
                      "NZ",
                      "OM",
                      "PA",
                      "PE",
                      "PH",
                      "PL",
                      "PS",
                      "PT",
                      "PY",
                      "QA",
                      "RO",
                      "RS",
                      "RU",
                      "SA",
                      "SE",
                      "SG",
                      "SI",
                      "SK",
                      "SV",
                      "TH",
                      "TN",
                      "TR",
                      "TW",
                      "UA",
                      "US",
                      "UY",
                      "VN",
                      "XK",
                      "ZA"
                  ],
                  "external_urls": {
                      "spotify": "https://open.spotify.com/album/4hR7jjsPvRwwcHx8ntJSQS"
                  },
                  "href": "https://api.spotify.com/v1/albums/4hR7jjsPvRwwcHx8ntJSQS",
                  "id": "4hR7jjsPvRwwcHx8ntJSQS",
                  "images": [
                      {
                          "height": 640,
                          "url": "https://i.scdn.co/image/ab67616d0000b273572c68f79b356c21202e248c",
                          "width": 640
                      },
                      {
                          "height": 300,
                          "url": "https://i.scdn.co/image/ab67616d00001e02572c68f79b356c21202e248c",
                          "width": 300
                      },
                      {
                          "height": 64,
                          "url": "https://i.scdn.co/image/ab67616d00004851572c68f79b356c21202e248c",
                          "width": 64
                      }
                  ],
                  "name": "Holy",
                  "release_date": "2020-09-18",
                  "release_date_precision": "day",
                  "total_tracks": 1,
                  "type": "album",
                  "uri": "spotify:album:4hR7jjsPvRwwcHx8ntJSQS"
              },
              {
                  "album_type": "single",
                  "artists": [
                      {
                          "external_urls": {
                              "spotify": "https://open.spotify.com/artist/2wY79sveU1sp5g7SokKOiI"
                          },
                          "href": "https://api.spotify.com/v1/artists/2wY79sveU1sp5g7SokKOiI",
                          "id": "2wY79sveU1sp5g7SokKOiI",
                          "name": "Sam Smith",
                          "type": "artist",
                          "uri": "spotify:artist:2wY79sveU1sp5g7SokKOiI"
                      }
                  ],
                  "available_markets": [
                      "AD",
                      "AE",
                      "AL",
                      "AR",
                      "AT",
                      "AU",
                      "BA",
                      "BE",
                      "BG",
                      "BH",
                      "BO",
                      "BR",
                      "BY",
                      "CA",
                      "CH",
                      "CL",
                      "CO",
                      "CR",
                      "CY",
                      "CZ",
                      "DE",
                      "DK",
                      "DO",
                      "DZ",
                      "EC",
                      "EE",
                      "EG",
                      "ES",
                      "FI",
                      "FR",
                      "GB",
                      "GR",
                      "GT",
                      "HK",
                      "HN",
                      "HR",
                      "HU",
                      "ID",
                      "IE",
                      "IL",
                      "IN",
                      "IS",
                      "IT",
                      "JO",
                      "JP",
                      "KW",
                      "KZ",
                      "LB",
                      "LI",
                      "LT",
                      "LU",
                      "LV",
                      "MA",
                      "MC",
                      "MD",
                      "ME",
                      "MK",
                      "MT",
                      "MX",
                      "MY",
                      "NI",
                      "NL",
                      "NO",
                      "NZ",
                      "OM",
                      "PA",
                      "PE",
                      "PH",
                      "PL",
                      "PS",
                      "PT",
                      "PY",
                      "QA",
                      "RO",
                      "RS",
                      "RU",
                      "SA",
                      "SG",
                      "SI",
                      "SK",
                      "SV",
                      "TH",
                      "TN",
                      "TR",
                      "TW",
                      "UA",
                      "US",
                      "UY",
                      "VN",
                      "XK",
                      "ZA"
                  ],
                  "external_urls": {
                      "spotify": "https://open.spotify.com/album/2IAyprsfyoPBGDvbLjgsN5"
                  },
                  "href": "https://api.spotify.com/v1/albums/2IAyprsfyoPBGDvbLjgsN5",
                  "id": "2IAyprsfyoPBGDvbLjgsN5",
                  "images": [
                      {
                          "height": 640,
                          "url": "https://i.scdn.co/image/ab67616d0000b273f207514228c0a5db1ae3b116",
                          "width": 640
                      },
                      {
                          "height": 300,
                          "url": "https://i.scdn.co/image/ab67616d00001e02f207514228c0a5db1ae3b116",
                          "width": 300
                      },
                      {
                          "height": 64,
                          "url": "https://i.scdn.co/image/ab67616d00004851f207514228c0a5db1ae3b116",
                          "width": 64
                      }
                  ],
                  "name": "Diamonds",
                  "release_date": "2020-09-17",
                  "release_date_precision": "day",
                  "total_tracks": 1,
                  "type": "album",
                  "uri": "spotify:album:2IAyprsfyoPBGDvbLjgsN5"
              },
              {
                  "album_type": "single",
                  "artists": [
                      {
                          "external_urls": {
                              "spotify": "https://open.spotify.com/artist/5VVN3xZw1i2qihfITZlvCZ"
                          },
                          "href": "https://api.spotify.com/v1/artists/5VVN3xZw1i2qihfITZlvCZ",
                          "id": "5VVN3xZw1i2qihfITZlvCZ",
                          "name": "G. V. Prakash",
                          "type": "artist",
                          "uri": "spotify:artist:5VVN3xZw1i2qihfITZlvCZ"
                      },
                      {
                          "external_urls": {
                              "spotify": "https://open.spotify.com/artist/0msMwWNlbZhRSsGqAQdPAs"
                          },
                          "href": "https://api.spotify.com/v1/artists/0msMwWNlbZhRSsGqAQdPAs",
                          "id": "0msMwWNlbZhRSsGqAQdPAs",
                          "name": "Julia Gartha",
                          "type": "artist",
                          "uri": "spotify:artist:0msMwWNlbZhRSsGqAQdPAs"
                      }
                  ],
                  "available_markets": [
                      "AD",
                      "AE",
                      "AL",
                      "AR",
                      "AT",
                      "AU",
                      "BA",
                      "BE",
                      "BG",
                      "BH",
                      "BO",
                      "BR",
                      "BY",
                      "CA",
                      "CH",
                      "CL",
                      "CO",
                      "CR",
                      "CY",
                      "CZ",
                      "DE",
                      "DK",
                      "DO",
                      "DZ",
                      "EC",
                      "EE",
                      "EG",
                      "ES",
                      "FI",
                      "FR",
                      "GB",
                      "GR",
                      "GT",
                      "HK",
                      "HN",
                      "HR",
                      "HU",
                      "ID",
                      "IE",
                      "IL",
                      "IN",
                      "IS",
                      "IT",
                      "JO",
                      "JP",
                      "KW",
                      "KZ",
                      "LB",
                      "LI",
                      "LT",
                      "LU",
                      "LV",
                      "MA",
                      "MC",
                      "MD",
                      "ME",
                      "MK",
                      "MT",
                      "MX",
                      "MY",
                      "NI",
                      "NL",
                      "NO",
                      "NZ",
                      "OM",
                      "PA",
                      "PE",
                      "PH",
                      "PL",
                      "PS",
                      "PT",
                      "PY",
                      "QA",
                      "RO",
                      "RS",
                      "RU",
                      "SA",
                      "SE",
                      "SG",
                      "SI",
                      "SK",
                      "SV",
                      "TH",
                      "TN",
                      "TR",
                      "TW",
                      "UA",
                      "US",
                      "UY",
                      "VN",
                      "XK",
                      "ZA"
                  ],
                  "external_urls": {
                      "spotify": "https://open.spotify.com/album/7rb98RQrdw6Oi2RAt38hIB"
                  },
                  "href": "https://api.spotify.com/v1/albums/7rb98RQrdw6Oi2RAt38hIB",
                  "id": "7rb98RQrdw6Oi2RAt38hIB",
                  "images": [
                      {
                          "height": 640,
                          "url": "https://i.scdn.co/image/ab67616d0000b27323d1128dbd11f83515eebe36",
                          "width": 640
                      },
                      {
                          "height": 300,
                          "url": "https://i.scdn.co/image/ab67616d00001e0223d1128dbd11f83515eebe36",
                          "width": 300
                      },
                      {
                          "height": 64,
                          "url": "https://i.scdn.co/image/ab67616d0000485123d1128dbd11f83515eebe36",
                          "width": 64
                      }
                  ],
                  "name": "High & Dry",
                  "release_date": "2020-09-17",
                  "release_date_precision": "day",
                  "total_tracks": 1,
                  "type": "album",
                  "uri": "spotify:album:7rb98RQrdw6Oi2RAt38hIB"
              },
              {
                  "album_type": "single",
                  "artists": [
                      {
                          "external_urls": {
                              "spotify": "https://open.spotify.com/artist/23fqKkggKUBHNkbKtXEls4"
                          },
                          "href": "https://api.spotify.com/v1/artists/23fqKkggKUBHNkbKtXEls4",
                          "id": "23fqKkggKUBHNkbKtXEls4",
                          "name": "Kygo",
                          "type": "artist",
                          "uri": "spotify:artist:23fqKkggKUBHNkbKtXEls4"
                      },
                      {
                          "external_urls": {
                              "spotify": "https://open.spotify.com/artist/2eogQKWWoohI3BSnoG7E2U"
                          },
                          "href": "https://api.spotify.com/v1/artists/2eogQKWWoohI3BSnoG7E2U",
                          "id": "2eogQKWWoohI3BSnoG7E2U",
                          "name": "Donna Summer",
                          "type": "artist",
                          "uri": "spotify:artist:2eogQKWWoohI3BSnoG7E2U"
                      }
                  ],
                  "available_markets": [
                      "AD",
                      "AE",
                      "AL",
                      "AR",
                      "AT",
                      "AU",
                      "BA",
                      "BE",
                      "BG",
                      "BH",
                      "BO",
                      "BR",
                      "BY",
                      "CA",
                      "CH",
                      "CL",
                      "CO",
                      "CR",
                      "CY",
                      "CZ",
                      "DE",
                      "DK",
                      "DO",
                      "DZ",
                      "EC",
                      "EE",
                      "EG",
                      "ES",
                      "FI",
                      "FR",
                      "GB",
                      "GR",
                      "GT",
                      "HK",
                      "HN",
                      "HR",
                      "HU",
                      "ID",
                      "IE",
                      "IL",
                      "IN",
                      "IS",
                      "IT",
                      "JO",
                      "JP",
                      "KW",
                      "KZ",
                      "LB",
                      "LI",
                      "LT",
                      "LU",
                      "LV",
                      "MA",
                      "MC",
                      "MD",
                      "ME",
                      "MK",
                      "MT",
                      "MX",
                      "MY",
                      "NI",
                      "NL",
                      "NO",
                      "NZ",
                      "OM",
                      "PA",
                      "PE",
                      "PH",
                      "PL",
                      "PS",
                      "PT",
                      "PY",
                      "QA",
                      "RO",
                      "RS",
                      "RU",
                      "SA",
                      "SE",
                      "SG",
                      "SI",
                      "SK",
                      "SV",
                      "TH",
                      "TN",
                      "TR",
                      "TW",
                      "UA",
                      "US",
                      "UY",
                      "VN",
                      "XK",
                      "ZA"
                  ],
                  "external_urls": {
                      "spotify": "https://open.spotify.com/album/6t95dMgjNYMtwXTKlISI42"
                  },
                  "href": "https://api.spotify.com/v1/albums/6t95dMgjNYMtwXTKlISI42",
                  "id": "6t95dMgjNYMtwXTKlISI42",
                  "images": [
                      {
                          "height": 640,
                          "url": "https://i.scdn.co/image/ab67616d0000b2738fc0ee2f829a7138af579c97",
                          "width": 640
                      },
                      {
                          "height": 300,
                          "url": "https://i.scdn.co/image/ab67616d00001e028fc0ee2f829a7138af579c97",
                          "width": 300
                      },
                      {
                          "height": 64,
                          "url": "https://i.scdn.co/image/ab67616d000048518fc0ee2f829a7138af579c97",
                          "width": 64
                      }
                  ],
                  "name": "Hot Stuff",
                  "release_date": "2020-09-18",
                  "release_date_precision": "day",
                  "total_tracks": 1,
                  "type": "album",
                  "uri": "spotify:album:6t95dMgjNYMtwXTKlISI42"
              },
              {
                  "album_type": "album",
                  "artists": [
                      {
                          "external_urls": {
                              "spotify": "https://open.spotify.com/artist/06HL4z0CvFAxyc27GXpf02"
                          },
                          "href": "https://api.spotify.com/v1/artists/06HL4z0CvFAxyc27GXpf02",
                          "id": "06HL4z0CvFAxyc27GXpf02",
                          "name": "Taylor Swift",
                          "type": "artist",
                          "uri": "spotify:artist:06HL4z0CvFAxyc27GXpf02"
                      }
                  ],
                  "available_markets": [
                      "AD",
                      "AE",
                      "AL",
                      "AR",
                      "AT",
                      "AU",
                      "BA",
                      "BE",
                      "BG",
                      "BH",
                      "BO",
                      "BR",
                      "BY",
                      "CA",
                      "CH",
                      "CL",
                      "CO",
                      "CR",
                      "CY",
                      "CZ",
                      "DE",
                      "DK",
                      "DO",
                      "DZ",
                      "EC",
                      "EE",
                      "EG",
                      "ES",
                      "FI",
                      "FR",
                      "GB",
                      "GR",
                      "GT",
                      "HK",
                      "HN",
                      "HR",
                      "HU",
                      "ID",
                      "IE",
                      "IL",
                      "IN",
                      "IS",
                      "IT",
                      "JO",
                      "JP",
                      "KW",
                      "KZ",
                      "LB",
                      "LI",
                      "LT",
                      "LU",
                      "LV",
                      "MA",
                      "MC",
                      "MD",
                      "ME",
                      "MK",
                      "MT",
                      "MX",
                      "MY",
                      "NI",
                      "NL",
                      "NO",
                      "NZ",
                      "OM",
                      "PA",
                      "PE",
                      "PH",
                      "PL",
                      "PS",
                      "PT",
                      "PY",
                      "QA",
                      "RO",
                      "RS",
                      "RU",
                      "SA",
                      "SE",
                      "SG",
                      "SI",
                      "SK",
                      "SV",
                      "TH",
                      "TN",
                      "TR",
                      "TW",
                      "UA",
                      "US",
                      "UY",
                      "VN",
                      "XK",
                      "ZA"
                  ],
                  "external_urls": {
                      "spotify": "https://open.spotify.com/album/2fenSS68JI1h4Fo296JfGr"
                  },
                  "href": "https://api.spotify.com/v1/albums/2fenSS68JI1h4Fo296JfGr",
                  "id": "2fenSS68JI1h4Fo296JfGr",
                  "images": [
                      {
                          "height": 640,
                          "url": "https://i.scdn.co/image/ab67616d0000b27395f754318336a07e85ec59bc",
                          "width": 640
                      },
                      {
                          "height": 300,
                          "url": "https://i.scdn.co/image/ab67616d00001e0295f754318336a07e85ec59bc",
                          "width": 300
                      },
                      {
                          "height": 64,
                          "url": "https://i.scdn.co/image/ab67616d0000485195f754318336a07e85ec59bc",
                          "width": 64
                      }
                  ],
                  "name": "folklore",
                  "release_date": "2020-07-24",
                  "release_date_precision": "day",
                  "total_tracks": 16,
                  "type": "album",
                  "uri": "spotify:album:2fenSS68JI1h4Fo296JfGr"
              },
              {
                  "album_type": "single",
                  "artists": [
                      {
                          "external_urls": {
                              "spotify": "https://open.spotify.com/artist/04gDigrS5kc9YWfZHwBETP"
                          },
                          "href": "https://api.spotify.com/v1/artists/04gDigrS5kc9YWfZHwBETP",
                          "id": "04gDigrS5kc9YWfZHwBETP",
                          "name": "Maroon 5",
                          "type": "artist",
                          "uri": "spotify:artist:04gDigrS5kc9YWfZHwBETP"
                      }
                  ],
                  "available_markets": [
                      "AD",
                      "AE",
                      "AL",
                      "AR",
                      "AT",
                      "AU",
                      "BA",
                      "BE",
                      "BG",
                      "BH",
                      "BO",
                      "BR",
                      "BY",
                      "CA",
                      "CH",
                      "CL",
                      "CO",
                      "CR",
                      "CY",
                      "CZ",
                      "DE",
                      "DK",
                      "DO",
                      "DZ",
                      "EC",
                      "EE",
                      "EG",
                      "ES",
                      "FI",
                      "FR",
                      "GB",
                      "GR",
                      "GT",
                      "HK",
                      "HN",
                      "HR",
                      "HU",
                      "ID",
                      "IE",
                      "IL",
                      "IN",
                      "IS",
                      "IT",
                      "JO",
                      "JP",
                      "KW",
                      "KZ",
                      "LB",
                      "LI",
                      "LT",
                      "LU",
                      "LV",
                      "MA",
                      "MC",
                      "MD",
                      "ME",
                      "MK",
                      "MT",
                      "MX",
                      "MY",
                      "NI",
                      "NL",
                      "NO",
                      "NZ",
                      "OM",
                      "PA",
                      "PE",
                      "PH",
                      "PL",
                      "PS",
                      "PT",
                      "PY",
                      "QA",
                      "RO",
                      "RS",
                      "RU",
                      "SA",
                      "SE",
                      "SG",
                      "SI",
                      "SK",
                      "SV",
                      "TH",
                      "TN",
                      "TR",
                      "TW",
                      "UA",
                      "US",
                      "UY",
                      "VN",
                      "XK",
                      "ZA"
                  ],
                  "external_urls": {
                      "spotify": "https://open.spotify.com/album/2cDt5R89HP8ZCXhNAmZs27"
                  },
                  "href": "https://api.spotify.com/v1/albums/2cDt5R89HP8ZCXhNAmZs27",
                  "id": "2cDt5R89HP8ZCXhNAmZs27",
                  "images": [
                      {
                          "height": 640,
                          "url": "https://i.scdn.co/image/ab67616d0000b273839deab240b73a3c76bf51eb",
                          "width": 640
                      },
                      {
                          "height": 300,
                          "url": "https://i.scdn.co/image/ab67616d00001e02839deab240b73a3c76bf51eb",
                          "width": 300
                      },
                      {
                          "height": 64,
                          "url": "https://i.scdn.co/image/ab67616d00004851839deab240b73a3c76bf51eb",
                          "width": 64
                      }
                  ],
                  "name": "Nobody's Love",
                  "release_date": "2020-07-24",
                  "release_date_precision": "day",
                  "total_tracks": 1,
                  "type": "album",
                  "uri": "spotify:album:2cDt5R89HP8ZCXhNAmZs27"
              },
              {
                  "album_type": "single",
                  "artists": [
                      {
                          "external_urls": {
                              "spotify": "https://open.spotify.com/artist/07YZf4WDAMNwqr4jfgOZ8y"
                          },
                          "href": "https://api.spotify.com/v1/artists/07YZf4WDAMNwqr4jfgOZ8y",
                          "id": "07YZf4WDAMNwqr4jfgOZ8y",
                          "name": "Jason Derulo",
                          "type": "artist",
                          "uri": "spotify:artist:07YZf4WDAMNwqr4jfgOZ8y"
                      }
                  ],
                  "available_markets": [
                      "AD",
                      "AE",
                      "AL",
                      "AR",
                      "AT",
                      "AU",
                      "BA",
                      "BE",
                      "BG",
                      "BH",
                      "BO",
                      "BR",
                      "BY",
                      "CA",
                      "CH",
                      "CL",
                      "CO",
                      "CR",
                      "CY",
                      "CZ",
                      "DE",
                      "DK",
                      "DO",
                      "DZ",
                      "EC",
                      "EE",
                      "EG",
                      "ES",
                      "FI",
                      "FR",
                      "GB",
                      "GR",
                      "GT",
                      "HK",
                      "HN",
                      "HR",
                      "HU",
                      "ID",
                      "IE",
                      "IL",
                      "IN",
                      "IS",
                      "IT",
                      "JO",
                      "JP",
                      "KW",
                      "KZ",
                      "LB",
                      "LI",
                      "LT",
                      "LU",
                      "LV",
                      "MA",
                      "MC",
                      "MD",
                      "ME",
                      "MK",
                      "MT",
                      "MX",
                      "MY",
                      "NI",
                      "NL",
                      "NO",
                      "NZ",
                      "OM",
                      "PA",
                      "PE",
                      "PH",
                      "PL",
                      "PS",
                      "PT",
                      "PY",
                      "QA",
                      "RO",
                      "RS",
                      "RU",
                      "SA",
                      "SE",
                      "SG",
                      "SI",
                      "SK",
                      "SV",
                      "TH",
                      "TN",
                      "TR",
                      "TW",
                      "UA",
                      "US",
                      "UY",
                      "VN",
                      "XK",
                      "ZA"
                  ],
                  "external_urls": {
                      "spotify": "https://open.spotify.com/album/3II80i5KpS38r0QjNzu8ly"
                  },
                  "href": "https://api.spotify.com/v1/albums/3II80i5KpS38r0QjNzu8ly",
                  "id": "3II80i5KpS38r0QjNzu8ly",
                  "images": [
                      {
                          "height": 640,
                          "url": "https://i.scdn.co/image/ab67616d0000b27354eab2e4aa8b8706b6b526d2",
                          "width": 640
                      },
                      {
                          "height": 300,
                          "url": "https://i.scdn.co/image/ab67616d00001e0254eab2e4aa8b8706b6b526d2",
                          "width": 300
                      },
                      {
                          "height": 64,
                          "url": "https://i.scdn.co/image/ab67616d0000485154eab2e4aa8b8706b6b526d2",
                          "width": 64
                      }
                  ],
                  "name": "Take You Dancing",
                  "release_date": "2020-07-22",
                  "release_date_precision": "day",
                  "total_tracks": 1,
                  "type": "album",
                  "uri": "spotify:album:3II80i5KpS38r0QjNzu8ly"
              },
              {
                  "album_type": "single",
                  "artists": [
                      {
                          "external_urls": {
                              "spotify": "https://open.spotify.com/artist/3gIRvgZssIb9aiirIg0nI3"
                          },
                          "href": "https://api.spotify.com/v1/artists/3gIRvgZssIb9aiirIg0nI3",
                          "id": "3gIRvgZssIb9aiirIg0nI3",
                          "name": "Jeremy Zucker",
                          "type": "artist",
                          "uri": "spotify:artist:3gIRvgZssIb9aiirIg0nI3"
                      }
                  ],
                  "available_markets": [
                      "AD",
                      "AE",
                      "AL",
                      "AR",
                      "AT",
                      "AU",
                      "BA",
                      "BE",
                      "BG",
                      "BH",
                      "BO",
                      "BR",
                      "BY",
                      "CA",
                      "CH",
                      "CL",
                      "CO",
                      "CR",
                      "CY",
                      "CZ",
                      "DE",
                      "DK",
                      "DO",
                      "DZ",
                      "EC",
                      "EE",
                      "EG",
                      "ES",
                      "FI",
                      "FR",
                      "GB",
                      "GR",
                      "GT",
                      "HK",
                      "HN",
                      "HR",
                      "HU",
                      "ID",
                      "IE",
                      "IL",
                      "IN",
                      "IS",
                      "IT",
                      "JO",
                      "JP",
                      "KW",
                      "KZ",
                      "LB",
                      "LI",
                      "LT",
                      "LU",
                      "LV",
                      "MA",
                      "MC",
                      "MD",
                      "ME",
                      "MK",
                      "MT",
                      "MX",
                      "MY",
                      "NI",
                      "NL",
                      "NO",
                      "NZ",
                      "OM",
                      "PA",
                      "PE",
                      "PH",
                      "PL",
                      "PS",
                      "PT",
                      "PY",
                      "QA",
                      "RO",
                      "RS",
                      "RU",
                      "SA",
                      "SE",
                      "SG",
                      "SI",
                      "SK",
                      "SV",
                      "TH",
                      "TN",
                      "TR",
                      "TW",
                      "UA",
                      "US",
                      "UY",
                      "VN",
                      "XK",
                      "ZA"
                  ],
                  "external_urls": {
                      "spotify": "https://open.spotify.com/album/2F1xmiVxAOHMIPOWcK97gg"
                  },
                  "href": "https://api.spotify.com/v1/albums/2F1xmiVxAOHMIPOWcK97gg",
                  "id": "2F1xmiVxAOHMIPOWcK97gg",
                  "images": [
                      {
                          "height": 640,
                          "url": "https://i.scdn.co/image/ab67616d0000b273c0e0e7f9e84a776c29d7012a",
                          "width": 640
                      },
                      {
                          "height": 300,
                          "url": "https://i.scdn.co/image/ab67616d00001e02c0e0e7f9e84a776c29d7012a",
                          "width": 300
                      },
                      {
                          "height": 64,
                          "url": "https://i.scdn.co/image/ab67616d00004851c0e0e7f9e84a776c29d7012a",
                          "width": 64
                      }
                  ],
                  "name": "supercuts",
                  "release_date": "2020-07-24",
                  "release_date_precision": "day",
                  "total_tracks": 1,
                  "type": "album",
                  "uri": "spotify:album:2F1xmiVxAOHMIPOWcK97gg"
              },
              {
                  "album_type": "single",
                  "artists": [
                      {
                          "external_urls": {
                              "spotify": "https://open.spotify.com/artist/1vyhD5VmyZ7KMfW5gqLgo5"
                          },
                          "href": "https://api.spotify.com/v1/artists/1vyhD5VmyZ7KMfW5gqLgo5",
                          "id": "1vyhD5VmyZ7KMfW5gqLgo5",
                          "name": "J Balvin",
                          "type": "artist",
                          "uri": "spotify:artist:1vyhD5VmyZ7KMfW5gqLgo5"
                      },
                      {
                          "external_urls": {
                              "spotify": "https://open.spotify.com/artist/6M2wZ9GZgrQXHCFfjv46we"
                          },
                          "href": "https://api.spotify.com/v1/artists/6M2wZ9GZgrQXHCFfjv46we",
                          "id": "6M2wZ9GZgrQXHCFfjv46we",
                          "name": "Dua Lipa",
                          "type": "artist",
                          "uri": "spotify:artist:6M2wZ9GZgrQXHCFfjv46we"
                      },
                      {
                          "external_urls": {
                              "spotify": "https://open.spotify.com/artist/4q3ewBCX7sLwd24euuV69X"
                          },
                          "href": "https://api.spotify.com/v1/artists/4q3ewBCX7sLwd24euuV69X",
                          "id": "4q3ewBCX7sLwd24euuV69X",
                          "name": "Bad Bunny",
                          "type": "artist",
                          "uri": "spotify:artist:4q3ewBCX7sLwd24euuV69X"
                      }
                  ],
                  "available_markets": [
                      "AD",
                      "AE",
                      "AL",
                      "AR",
                      "AT",
                      "AU",
                      "BA",
                      "BE",
                      "BG",
                      "BH",
                      "BO",
                      "BR",
                      "BY",
                      "CA",
                      "CH",
                      "CL",
                      "CO",
                      "CR",
                      "CY",
                      "CZ",
                      "DE",
                      "DK",
                      "DO",
                      "DZ",
                      "EC",
                      "EE",
                      "EG",
                      "ES",
                      "FI",
                      "FR",
                      "GB",
                      "GR",
                      "GT",
                      "HK",
                      "HN",
                      "HR",
                      "HU",
                      "ID",
                      "IE",
                      "IL",
                      "IN",
                      "IS",
                      "IT",
                      "JO",
                      "JP",
                      "KW",
                      "KZ",
                      "LB",
                      "LI",
                      "LT",
                      "LU",
                      "LV",
                      "MA",
                      "MC",
                      "MD",
                      "ME",
                      "MK",
                      "MT",
                      "MX",
                      "MY",
                      "NI",
                      "NL",
                      "NO",
                      "NZ",
                      "OM",
                      "PA",
                      "PE",
                      "PH",
                      "PL",
                      "PS",
                      "PT",
                      "PY",
                      "QA",
                      "RO",
                      "RS",
                      "RU",
                      "SA",
                      "SE",
                      "SG",
                      "SI",
                      "SK",
                      "SV",
                      "TH",
                      "TN",
                      "TR",
                      "TW",
                      "UA",
                      "US",
                      "UY",
                      "VN",
                      "XK",
                      "ZA"
                  ],
                  "external_urls": {
                      "spotify": "https://open.spotify.com/album/6aqSlutLYNpzSsK4dV5jTr"
                  },
                  "href": "https://api.spotify.com/v1/albums/6aqSlutLYNpzSsK4dV5jTr",
                  "id": "6aqSlutLYNpzSsK4dV5jTr",
                  "images": [
                      {
                          "height": 640,
                          "url": "https://i.scdn.co/image/ab67616d0000b273312bd86cc2db22fde885ee73",
                          "width": 640
                      },
                      {
                          "height": 300,
                          "url": "https://i.scdn.co/image/ab67616d00001e02312bd86cc2db22fde885ee73",
                          "width": 300
                      },
                      {
                          "height": 64,
                          "url": "https://i.scdn.co/image/ab67616d00004851312bd86cc2db22fde885ee73",
                          "width": 64
                      }
                  ],
                  "name": "UN DIA (ONE DAY) (Feat. Tainy)",
                  "release_date": "2020-07-24",
                  "release_date_precision": "day",
                  "total_tracks": 1,
                  "type": "album",
                  "uri": "spotify:album:6aqSlutLYNpzSsK4dV5jTr"
              },
              {
                  "album_type": "single",
                  "artists": [
                      {
                          "external_urls": {
                              "spotify": "https://open.spotify.com/artist/5cBFMoMgcAt03YL2r0tS25"
                          },
                          "href": "https://api.spotify.com/v1/artists/5cBFMoMgcAt03YL2r0tS25",
                          "id": "5cBFMoMgcAt03YL2r0tS25",
                          "name": "Raja Kumari",
                          "type": "artist",
                          "uri": "spotify:artist:5cBFMoMgcAt03YL2r0tS25"
                      }
                  ],
                  "available_markets": [
                      "AD",
                      "AE",
                      "AL",
                      "AR",
                      "AT",
                      "AU",
                      "BA",
                      "BE",
                      "BG",
                      "BH",
                      "BO",
                      "BR",
                      "BY",
                      "CA",
                      "CH",
                      "CL",
                      "CO",
                      "CR",
                      "CY",
                      "CZ",
                      "DE",
                      "DK",
                      "DO",
                      "DZ",
                      "EC",
                      "EE",
                      "EG",
                      "ES",
                      "FI",
                      "FR",
                      "GB",
                      "GR",
                      "GT",
                      "HK",
                      "HN",
                      "HR",
                      "HU",
                      "ID",
                      "IE",
                      "IL",
                      "IN",
                      "IS",
                      "IT",
                      "JO",
                      "JP",
                      "KW",
                      "KZ",
                      "LB",
                      "LI",
                      "LT",
                      "LU",
                      "LV",
                      "MA",
                      "MC",
                      "MD",
                      "ME",
                      "MK",
                      "MT",
                      "MX",
                      "MY",
                      "NI",
                      "NL",
                      "NO",
                      "NZ",
                      "OM",
                      "PA",
                      "PE",
                      "PH",
                      "PL",
                      "PS",
                      "PT",
                      "PY",
                      "QA",
                      "RO",
                      "RS",
                      "RU",
                      "SA",
                      "SE",
                      "SG",
                      "SI",
                      "SK",
                      "SV",
                      "TH",
                      "TN",
                      "TR",
                      "TW",
                      "UA",
                      "US",
                      "UY",
                      "VN",
                      "XK",
                      "ZA"
                  ],
                  "external_urls": {
                      "spotify": "https://open.spotify.com/album/1kvlEm330XRmAZTHY3X3vc"
                  },
                  "href": "https://api.spotify.com/v1/albums/1kvlEm330XRmAZTHY3X3vc",
                  "id": "1kvlEm330XRmAZTHY3X3vc",
                  "images": [
                      {
                          "height": 640,
                          "url": "https://i.scdn.co/image/ab67616d0000b2730a4573ebae3b20b59ee608ab",
                          "width": 640
                      },
                      {
                          "height": 300,
                          "url": "https://i.scdn.co/image/ab67616d00001e020a4573ebae3b20b59ee608ab",
                          "width": 300
                      },
                      {
                          "height": 64,
                          "url": "https://i.scdn.co/image/ab67616d000048510a4573ebae3b20b59ee608ab",
                          "width": 64
                      }
                  ],
                  "name": "PEACE",
                  "release_date": "2020-07-03",
                  "release_date_precision": "day",
                  "total_tracks": 1,
                  "type": "album",
                  "uri": "spotify:album:1kvlEm330XRmAZTHY3X3vc"
              },
              {
                  "album_type": "single",
                  "artists": [
                      {
                          "external_urls": {
                              "spotify": "https://open.spotify.com/artist/07YZf4WDAMNwqr4jfgOZ8y"
                          },
                          "href": "https://api.spotify.com/v1/artists/07YZf4WDAMNwqr4jfgOZ8y",
                          "id": "07YZf4WDAMNwqr4jfgOZ8y",
                          "name": "Jason Derulo",
                          "type": "artist",
                          "uri": "spotify:artist:07YZf4WDAMNwqr4jfgOZ8y"
                      },
                      {
                          "external_urls": {
                              "spotify": "https://open.spotify.com/artist/3ADyFy1orEwODaiHmRRMQp"
                          },
                          "href": "https://api.spotify.com/v1/artists/3ADyFy1orEwODaiHmRRMQp",
                          "id": "3ADyFy1orEwODaiHmRRMQp",
                          "name": "Puri",
                          "type": "artist",
                          "uri": "spotify:artist:3ADyFy1orEwODaiHmRRMQp"
                      },
                      {
                          "external_urls": {
                              "spotify": "https://open.spotify.com/artist/3aAX2y0amckZ7WcWoz2f2o"
                          },
                          "href": "https://api.spotify.com/v1/artists/3aAX2y0amckZ7WcWoz2f2o",
                          "id": "3aAX2y0amckZ7WcWoz2f2o",
                          "name": "Jhorrmountain",
                          "type": "artist",
                          "uri": "spotify:artist:3aAX2y0amckZ7WcWoz2f2o"
                      }
                  ],
                  "available_markets": [
                      "AD",
                      "AE",
                      "AL",
                      "AR",
                      "AT",
                      "AU",
                      "BA",
                      "BE",
                      "BG",
                      "BH",
                      "BO",
                      "BR",
                      "BY",
                      "CA",
                      "CH",
                      "CL",
                      "CO",
                      "CR",
                      "CY",
                      "CZ",
                      "DE",
                      "DK",
                      "DO",
                      "DZ",
                      "EC",
                      "EE",
                      "EG",
                      "ES",
                      "FI",
                      "FR",
                      "GB",
                      "GR",
                      "GT",
                      "HK",
                      "HN",
                      "HR",
                      "HU",
                      "ID",
                      "IE",
                      "IL",
                      "IN",
                      "IS",
                      "IT",
                      "JO",
                      "JP",
                      "KW",
                      "KZ",
                      "LB",
                      "LI",
                      "LT",
                      "LU",
                      "LV",
                      "MA",
                      "MC",
                      "MD",
                      "ME",
                      "MK",
                      "MT",
                      "MX",
                      "MY",
                      "NI",
                      "NL",
                      "NO",
                      "NZ",
                      "OM",
                      "PA",
                      "PE",
                      "PH",
                      "PL",
                      "PS",
                      "PT",
                      "PY",
                      "QA",
                      "RO",
                      "RS",
                      "RU",
                      "SA",
                      "SE",
                      "SG",
                      "SI",
                      "SK",
                      "SV",
                      "TH",
                      "TN",
                      "TR",
                      "TW",
                      "UA",
                      "US",
                      "UY",
                      "VN",
                      "XK",
                      "ZA"
                  ],
                  "external_urls": {
                      "spotify": "https://open.spotify.com/album/1h3x5tLWXhf438Y5AK60Ml"
                  },
                  "href": "https://api.spotify.com/v1/albums/1h3x5tLWXhf438Y5AK60Ml",
                  "id": "1h3x5tLWXhf438Y5AK60Ml",
                  "images": [
                      {
                          "height": 640,
                          "url": "https://i.scdn.co/image/ab67616d0000b2731d56717d1786e938a105b6df",
                          "width": 640
                      },
                      {
                          "height": 300,
                          "url": "https://i.scdn.co/image/ab67616d00001e021d56717d1786e938a105b6df",
                          "width": 300
                      },
                      {
                          "height": 64,
                          "url": "https://i.scdn.co/image/ab67616d000048511d56717d1786e938a105b6df",
                          "width": 64
                      }
                  ],
                  "name": "Coño",
                  "release_date": "2020-07-03",
                  "release_date_precision": "day",
                  "total_tracks": 1,
                  "type": "album",
                  "uri": "spotify:album:1h3x5tLWXhf438Y5AK60Ml"
              },
              {
                  "album_type": "single",
                  "artists": [
                      {
                          "external_urls": {
                              "spotify": "https://open.spotify.com/artist/0X2BH1fck6amBIoJhDVmmJ"
                          },
                          "href": "https://api.spotify.com/v1/artists/0X2BH1fck6amBIoJhDVmmJ",
                          "id": "0X2BH1fck6amBIoJhDVmmJ",
                          "name": "Ellie Goulding",
                          "type": "artist",
                          "uri": "spotify:artist:0X2BH1fck6amBIoJhDVmmJ"
                      }
                  ],
                  "available_markets": [
                      "AD",
                      "AE",
                      "AL",
                      "AR",
                      "AT",
                      "AU",
                      "BA",
                      "BE",
                      "BG",
                      "BH",
                      "BO",
                      "BR",
                      "BY",
                      "CA",
                      "CH",
                      "CL",
                      "CO",
                      "CR",
                      "CY",
                      "CZ",
                      "DE",
                      "DK",
                      "DO",
                      "DZ",
                      "EC",
                      "EE",
                      "EG",
                      "ES",
                      "FI",
                      "FR",
                      "GB",
                      "GR",
                      "GT",
                      "HK",
                      "HN",
                      "HR",
                      "HU",
                      "ID",
                      "IE",
                      "IL",
                      "IN",
                      "IS",
                      "IT",
                      "JO",
                      "JP",
                      "KW",
                      "KZ",
                      "LB",
                      "LI",
                      "LT",
                      "LU",
                      "LV",
                      "MA",
                      "MC",
                      "MD",
                      "ME",
                      "MK",
                      "MT",
                      "MX",
                      "MY",
                      "NI",
                      "NL",
                      "NO",
                      "NZ",
                      "OM",
                      "PA",
                      "PE",
                      "PH",
                      "PL",
                      "PS",
                      "PT",
                      "PY",
                      "QA",
                      "RO",
                      "RS",
                      "RU",
                      "SA",
                      "SE",
                      "SG",
                      "SI",
                      "SK",
                      "SV",
                      "TH",
                      "TN",
                      "TR",
                      "TW",
                      "UA",
                      "US",
                      "UY",
                      "VN",
                      "XK",
                      "ZA"
                  ],
                  "external_urls": {
                      "spotify": "https://open.spotify.com/album/15Zgvxqql6EPHE3NJlUt0R"
                  },
                  "href": "https://api.spotify.com/v1/albums/15Zgvxqql6EPHE3NJlUt0R",
                  "id": "15Zgvxqql6EPHE3NJlUt0R",
                  "images": [
                      {
                          "height": 640,
                          "url": "https://i.scdn.co/image/ab67616d0000b2734fb1446223808a37ba8914b5",
                          "width": 640
                      },
                      {
                          "height": 300,
                          "url": "https://i.scdn.co/image/ab67616d00001e024fb1446223808a37ba8914b5",
                          "width": 300
                      },
                      {
                          "height": 64,
                          "url": "https://i.scdn.co/image/ab67616d000048514fb1446223808a37ba8914b5",
                          "width": 64
                      }
                  ],
                  "name": "Slow Grenade",
                  "release_date": "2020-06-30",
                  "release_date_precision": "day",
                  "total_tracks": 6,
                  "type": "album",
                  "uri": "spotify:album:15Zgvxqql6EPHE3NJlUt0R"
              },
              {
                  "album_type": "single",
                  "artists": [
                      {
                          "external_urls": {
                              "spotify": "https://open.spotify.com/artist/5K4W6rqBFWDnAN6FQUkS6x"
                          },
                          "href": "https://api.spotify.com/v1/artists/5K4W6rqBFWDnAN6FQUkS6x",
                          "id": "5K4W6rqBFWDnAN6FQUkS6x",
                          "name": "Kanye West",
                          "type": "artist",
                          "uri": "spotify:artist:5K4W6rqBFWDnAN6FQUkS6x"
                      },
                      {
                          "external_urls": {
                              "spotify": "https://open.spotify.com/artist/0Y5tJX1MQlPlqiwlOH1tJY"
                          },
                          "href": "https://api.spotify.com/v1/artists/0Y5tJX1MQlPlqiwlOH1tJY",
                          "id": "0Y5tJX1MQlPlqiwlOH1tJY",
                          "name": "Travis Scott",
                          "type": "artist",
                          "uri": "spotify:artist:0Y5tJX1MQlPlqiwlOH1tJY"
                      }
                  ],
                  "available_markets": [
                      "AD",
                      "AE",
                      "AL",
                      "AR",
                      "AT",
                      "AU",
                      "BA",
                      "BE",
                      "BG",
                      "BH",
                      "BO",
                      "BR",
                      "BY",
                      "CA",
                      "CH",
                      "CL",
                      "CO",
                      "CR",
                      "CY",
                      "CZ",
                      "DE",
                      "DK",
                      "DO",
                      "DZ",
                      "EC",
                      "EE",
                      "EG",
                      "ES",
                      "FI",
                      "FR",
                      "GB",
                      "GR",
                      "GT",
                      "HK",
                      "HN",
                      "HR",
                      "HU",
                      "ID",
                      "IE",
                      "IL",
                      "IN",
                      "IS",
                      "IT",
                      "JO",
                      "JP",
                      "KW",
                      "KZ",
                      "LB",
                      "LI",
                      "LT",
                      "LU",
                      "LV",
                      "MA",
                      "MC",
                      "MD",
                      "ME",
                      "MK",
                      "MT",
                      "MX",
                      "MY",
                      "NI",
                      "NL",
                      "NO",
                      "NZ",
                      "OM",
                      "PA",
                      "PE",
                      "PH",
                      "PL",
                      "PS",
                      "PT",
                      "PY",
                      "QA",
                      "RO",
                      "RS",
                      "RU",
                      "SA",
                      "SE",
                      "SG",
                      "SI",
                      "SK",
                      "SV",
                      "TH",
                      "TN",
                      "TR",
                      "TW",
                      "UA",
                      "US",
                      "UY",
                      "VN",
                      "XK",
                      "ZA"
                  ],
                  "external_urls": {
                      "spotify": "https://open.spotify.com/album/7jQPy8GhgSuT5A54pb5sHx"
                  },
                  "href": "https://api.spotify.com/v1/albums/7jQPy8GhgSuT5A54pb5sHx",
                  "id": "7jQPy8GhgSuT5A54pb5sHx",
                  "images": [
                      {
                          "height": 640,
                          "url": "https://i.scdn.co/image/ab67616d0000b2732b2de7835bc93f1e368cee6d",
                          "width": 640
                      },
                      {
                          "height": 300,
                          "url": "https://i.scdn.co/image/ab67616d00001e022b2de7835bc93f1e368cee6d",
                          "width": 300
                      },
                      {
                          "height": 64,
                          "url": "https://i.scdn.co/image/ab67616d000048512b2de7835bc93f1e368cee6d",
                          "width": 64
                      }
                  ],
                  "name": "Wash Us In The Blood",
                  "release_date": "2020-06-30",
                  "release_date_precision": "day",
                  "total_tracks": 1,
                  "type": "album",
                  "uri": "spotify:album:7jQPy8GhgSuT5A54pb5sHx"
              },
              {
                  "album_type": "album",
                  "artists": [
                      {
                          "external_urls": {
                              "spotify": "https://open.spotify.com/artist/1HY2Jd0NmPuamShAr6KMms"
                          },
                          "href": "https://api.spotify.com/v1/artists/1HY2Jd0NmPuamShAr6KMms",
                          "id": "1HY2Jd0NmPuamShAr6KMms",
                          "name": "Lady Gaga",
                          "type": "artist",
                          "uri": "spotify:artist:1HY2Jd0NmPuamShAr6KMms"
                      }
                  ],
                  "available_markets": [
                      "AD",
                      "AE",
                      "AL",
                      "AR",
                      "AT",
                      "AU",
                      "BA",
                      "BE",
                      "BG",
                      "BH",
                      "BO",
                      "BR",
                      "BY",
                      "CA",
                      "CH",
                      "CL",
                      "CO",
                      "CR",
                      "CY",
                      "CZ",
                      "DE",
                      "DK",
                      "DO",
                      "DZ",
                      "EC",
                      "EE",
                      "EG",
                      "ES",
                      "FI",
                      "FR",
                      "GB",
                      "GR",
                      "GT",
                      "HK",
                      "HN",
                      "HR",
                      "HU",
                      "ID",
                      "IE",
                      "IL",
                      "IN",
                      "IS",
                      "IT",
                      "JO",
                      "JP",
                      "KW",
                      "KZ",
                      "LB",
                      "LI",
                      "LT",
                      "LU",
                      "LV",
                      "MA",
                      "MC",
                      "MD",
                      "ME",
                      "MK",
                      "MT",
                      "MX",
                      "MY",
                      "NI",
                      "NL",
                      "NO",
                      "NZ",
                      "OM",
                      "PA",
                      "PE",
                      "PH",
                      "PL",
                      "PS",
                      "PT",
                      "PY",
                      "QA",
                      "RO",
                      "RS",
                      "RU",
                      "SA",
                      "SE",
                      "SG",
                      "SI",
                      "SK",
                      "SV",
                      "TH",
                      "TN",
                      "TR",
                      "TW",
                      "UA",
                      "US",
                      "UY",
                      "VN",
                      "XK",
                      "ZA"
                  ],
                  "external_urls": {
                      "spotify": "https://open.spotify.com/album/05c49JgPmL4Uz2ZeqRx5SP"
                  },
                  "href": "https://api.spotify.com/v1/albums/05c49JgPmL4Uz2ZeqRx5SP",
                  "id": "05c49JgPmL4Uz2ZeqRx5SP",
                  "images": [
                      {
                          "height": 640,
                          "url": "https://i.scdn.co/image/ab67616d0000b2736040effba89b9b00a6f6743a",
                          "width": 640
                      },
                      {
                          "height": 300,
                          "url": "https://i.scdn.co/image/ab67616d00001e026040effba89b9b00a6f6743a",
                          "width": 300
                      },
                      {
                          "height": 64,
                          "url": "https://i.scdn.co/image/ab67616d000048516040effba89b9b00a6f6743a",
                          "width": 64
                      }
                  ],
                  "name": "Chromatica",
                  "release_date": "2020-05-29",
                  "release_date_precision": "day",
                  "total_tracks": 16,
                  "type": "album",
                  "uri": "spotify:album:05c49JgPmL4Uz2ZeqRx5SP"
              },
              {
                  "album_type": "single",
                  "artists": [
                      {
                          "external_urls": {
                              "spotify": "https://open.spotify.com/artist/7ltDVBr6mKbRvohxheJ9h1"
                          },
                          "href": "https://api.spotify.com/v1/artists/7ltDVBr6mKbRvohxheJ9h1",
                          "id": "7ltDVBr6mKbRvohxheJ9h1",
                          "name": "ROSALÍA",
                          "type": "artist",
                          "uri": "spotify:artist:7ltDVBr6mKbRvohxheJ9h1"
                      },
                      {
                          "external_urls": {
                              "spotify": "https://open.spotify.com/artist/0Y5tJX1MQlPlqiwlOH1tJY"
                          },
                          "href": "https://api.spotify.com/v1/artists/0Y5tJX1MQlPlqiwlOH1tJY",
                          "id": "0Y5tJX1MQlPlqiwlOH1tJY",
                          "name": "Travis Scott",
                          "type": "artist",
                          "uri": "spotify:artist:0Y5tJX1MQlPlqiwlOH1tJY"
                      }
                  ],
                  "available_markets": [
                      "AD",
                      "AE",
                      "AL",
                      "AR",
                      "AT",
                      "AU",
                      "BA",
                      "BE",
                      "BG",
                      "BH",
                      "BO",
                      "BR",
                      "BY",
                      "CA",
                      "CH",
                      "CL",
                      "CO",
                      "CR",
                      "CY",
                      "CZ",
                      "DE",
                      "DK",
                      "DO",
                      "DZ",
                      "EC",
                      "EE",
                      "EG",
                      "ES",
                      "FI",
                      "FR",
                      "GB",
                      "GR",
                      "GT",
                      "HK",
                      "HN",
                      "HR",
                      "HU",
                      "ID",
                      "IE",
                      "IL",
                      "IN",
                      "IS",
                      "IT",
                      "JO",
                      "JP",
                      "KW",
                      "KZ",
                      "LB",
                      "LI",
                      "LT",
                      "LU",
                      "LV",
                      "MA",
                      "MC",
                      "MD",
                      "ME",
                      "MK",
                      "MT",
                      "MX",
                      "MY",
                      "NI",
                      "NL",
                      "NO",
                      "NZ",
                      "OM",
                      "PA",
                      "PE",
                      "PH",
                      "PL",
                      "PS",
                      "PT",
                      "PY",
                      "QA",
                      "RO",
                      "RS",
                      "RU",
                      "SA",
                      "SE",
                      "SG",
                      "SI",
                      "SK",
                      "SV",
                      "TH",
                      "TN",
                      "TR",
                      "TW",
                      "UA",
                      "US",
                      "UY",
                      "VN",
                      "XK",
                      "ZA"
                  ],
                  "external_urls": {
                      "spotify": "https://open.spotify.com/album/4KEOAWBMpvJrIZ7tQfx44i"
                  },
                  "href": "https://api.spotify.com/v1/albums/4KEOAWBMpvJrIZ7tQfx44i",
                  "id": "4KEOAWBMpvJrIZ7tQfx44i",
                  "images": [
                      {
                          "height": 640,
                          "url": "https://i.scdn.co/image/ab67616d0000b2732a3d01289b78099e4508ba0e",
                          "width": 640
                      },
                      {
                          "height": 300,
                          "url": "https://i.scdn.co/image/ab67616d00001e022a3d01289b78099e4508ba0e",
                          "width": 300
                      },
                      {
                          "height": 64,
                          "url": "https://i.scdn.co/image/ab67616d000048512a3d01289b78099e4508ba0e",
                          "width": 64
                      }
                  ],
                  "name": "TKN (feat. Travis Scott)",
                  "release_date": "2020-05-28",
                  "release_date_precision": "day",
                  "total_tracks": 1,
                  "type": "album",
                  "uri": "spotify:album:4KEOAWBMpvJrIZ7tQfx44i"
              },
              {
                  "album_type": "album",
                  "artists": [
                      {
                          "external_urls": {
                              "spotify": "https://open.spotify.com/artist/23fqKkggKUBHNkbKtXEls4"
                          },
                          "href": "https://api.spotify.com/v1/artists/23fqKkggKUBHNkbKtXEls4",
                          "id": "23fqKkggKUBHNkbKtXEls4",
                          "name": "Kygo",
                          "type": "artist",
                          "uri": "spotify:artist:23fqKkggKUBHNkbKtXEls4"
                      }
                  ],
                  "available_markets": [
                      "AD",
                      "AE",
                      "AL",
                      "AR",
                      "AT",
                      "AU",
                      "BA",
                      "BE",
                      "BG",
                      "BH",
                      "BO",
                      "BR",
                      "BY",
                      "CA",
                      "CH",
                      "CL",
                      "CO",
                      "CR",
                      "CY",
                      "CZ",
                      "DE",
                      "DK",
                      "DO",
                      "DZ",
                      "EC",
                      "EE",
                      "EG",
                      "ES",
                      "FI",
                      "FR",
                      "GB",
                      "GR",
                      "GT",
                      "HK",
                      "HN",
                      "HR",
                      "HU",
                      "ID",
                      "IE",
                      "IL",
                      "IN",
                      "IS",
                      "IT",
                      "JO",
                      "JP",
                      "KW",
                      "KZ",
                      "LB",
                      "LI",
                      "LT",
                      "LU",
                      "LV",
                      "MA",
                      "MC",
                      "MD",
                      "ME",
                      "MK",
                      "MT",
                      "MX",
                      "MY",
                      "NI",
                      "NL",
                      "NO",
                      "NZ",
                      "OM",
                      "PA",
                      "PE",
                      "PH",
                      "PL",
                      "PS",
                      "PT",
                      "PY",
                      "QA",
                      "RO",
                      "RS",
                      "RU",
                      "SA",
                      "SE",
                      "SG",
                      "SI",
                      "SK",
                      "SV",
                      "TH",
                      "TN",
                      "TR",
                      "TW",
                      "UA",
                      "US",
                      "UY",
                      "VN",
                      "XK",
                      "ZA"
                  ],
                  "external_urls": {
                      "spotify": "https://open.spotify.com/album/7tcs1X9pzFvcLOPuhCstQJ"
                  },
                  "href": "https://api.spotify.com/v1/albums/7tcs1X9pzFvcLOPuhCstQJ",
                  "id": "7tcs1X9pzFvcLOPuhCstQJ",
                  "images": [
                      {
                          "height": 640,
                          "url": "https://i.scdn.co/image/ab67616d0000b27380368f0aa8f90c51674f9dd2",
                          "width": 640
                      },
                      {
                          "height": 300,
                          "url": "https://i.scdn.co/image/ab67616d00001e0280368f0aa8f90c51674f9dd2",
                          "width": 300
                      },
                      {
                          "height": 64,
                          "url": "https://i.scdn.co/image/ab67616d0000485180368f0aa8f90c51674f9dd2",
                          "width": 64
                      }
                  ],
                  "name": "Golden Hour",
                  "release_date": "2020-05-29",
                  "release_date_precision": "day",
                  "total_tracks": 18,
                  "type": "album",
                  "uri": "spotify:album:7tcs1X9pzFvcLOPuhCstQJ"
              },
              {
                  "album_type": "single",
                  "artists": [
                      {
                          "external_urls": {
                              "spotify": "https://open.spotify.com/artist/5npIe0yBbHoAwQ5XYVVEwn"
                          },
                          "href": "https://api.spotify.com/v1/artists/5npIe0yBbHoAwQ5XYVVEwn",
                          "id": "5npIe0yBbHoAwQ5XYVVEwn",
                          "name": "Dhruv Visvanath",
                          "type": "artist",
                          "uri": "spotify:artist:5npIe0yBbHoAwQ5XYVVEwn"
                      }
                  ],
                  "available_markets": [
                      "AD",
                      "AE",
                      "AL",
                      "AR",
                      "AT",
                      "AU",
                      "BA",
                      "BE",
                      "BG",
                      "BH",
                      "BO",
                      "BR",
                      "BY",
                      "CA",
                      "CH",
                      "CL",
                      "CO",
                      "CR",
                      "CY",
                      "CZ",
                      "DE",
                      "DK",
                      "DO",
                      "DZ",
                      "EC",
                      "EE",
                      "EG",
                      "ES",
                      "FI",
                      "FR",
                      "GB",
                      "GR",
                      "GT",
                      "HK",
                      "HN",
                      "HR",
                      "HU",
                      "ID",
                      "IE",
                      "IL",
                      "IN",
                      "IS",
                      "IT",
                      "JO",
                      "JP",
                      "KW",
                      "KZ",
                      "LB",
                      "LI",
                      "LT",
                      "LU",
                      "LV",
                      "MA",
                      "MC",
                      "MD",
                      "ME",
                      "MK",
                      "MT",
                      "MX",
                      "MY",
                      "NI",
                      "NL",
                      "NO",
                      "NZ",
                      "OM",
                      "PA",
                      "PE",
                      "PH",
                      "PL",
                      "PS",
                      "PT",
                      "PY",
                      "QA",
                      "RO",
                      "RS",
                      "RU",
                      "SA",
                      "SE",
                      "SG",
                      "SI",
                      "SK",
                      "SV",
                      "TH",
                      "TN",
                      "TR",
                      "TW",
                      "UA",
                      "US",
                      "UY",
                      "VN",
                      "XK",
                      "ZA"
                  ],
                  "external_urls": {
                      "spotify": "https://open.spotify.com/album/1hNvQUcwjcsQtDAHkaO6Ix"
                  },
                  "href": "https://api.spotify.com/v1/albums/1hNvQUcwjcsQtDAHkaO6Ix",
                  "id": "1hNvQUcwjcsQtDAHkaO6Ix",
                  "images": [
                      {
                          "height": 640,
                          "url": "https://i.scdn.co/image/ab67616d0000b273630b37a1610043b5b0522cdc",
                          "width": 640
                      },
                      {
                          "height": 300,
                          "url": "https://i.scdn.co/image/ab67616d00001e02630b37a1610043b5b0522cdc",
                          "width": 300
                      },
                      {
                          "height": 64,
                          "url": "https://i.scdn.co/image/ab67616d00004851630b37a1610043b5b0522cdc",
                          "width": 64
                      }
                  ],
                  "name": "Dark",
                  "release_date": "2020-05-22",
                  "release_date_precision": "day",
                  "total_tracks": 1,
                  "type": "album",
                  "uri": "spotify:album:1hNvQUcwjcsQtDAHkaO6Ix"
              },
              {
                  "album_type": "single",
                  "artists": [
                      {
                          "external_urls": {
                              "spotify": "https://open.spotify.com/artist/5WUlDfRSoLAfcVSX1WnrxN"
                          },
                          "href": "https://api.spotify.com/v1/artists/5WUlDfRSoLAfcVSX1WnrxN",
                          "id": "5WUlDfRSoLAfcVSX1WnrxN",
                          "name": "Sia",
                          "type": "artist",
                          "uri": "spotify:artist:5WUlDfRSoLAfcVSX1WnrxN"
                      }
                  ],
                  "available_markets": [
                      "AD",
                      "AE",
                      "AL",
                      "AR",
                      "AT",
                      "AU",
                      "BA",
                      "BE",
                      "BG",
                      "BH",
                      "BO",
                      "BR",
                      "BY",
                      "CA",
                      "CH",
                      "CL",
                      "CO",
                      "CR",
                      "CY",
                      "CZ",
                      "DE",
                      "DK",
                      "DO",
                      "DZ",
                      "EC",
                      "EE",
                      "EG",
                      "ES",
                      "FI",
                      "FR",
                      "GB",
                      "GR",
                      "GT",
                      "HK",
                      "HN",
                      "HR",
                      "HU",
                      "ID",
                      "IE",
                      "IL",
                      "IN",
                      "IS",
                      "IT",
                      "JO",
                      "JP",
                      "KW",
                      "KZ",
                      "LB",
                      "LI",
                      "LT",
                      "LU",
                      "LV",
                      "MA",
                      "MC",
                      "MD",
                      "ME",
                      "MK",
                      "MT",
                      "MX",
                      "MY",
                      "NI",
                      "NL",
                      "NO",
                      "NZ",
                      "OM",
                      "PA",
                      "PE",
                      "PH",
                      "PL",
                      "PS",
                      "PT",
                      "PY",
                      "QA",
                      "RO",
                      "RS",
                      "RU",
                      "SA",
                      "SE",
                      "SG",
                      "SI",
                      "SK",
                      "SV",
                      "TH",
                      "TN",
                      "TR",
                      "TW",
                      "UA",
                      "US",
                      "UY",
                      "VN",
                      "XK",
                      "ZA"
                  ],
                  "external_urls": {
                      "spotify": "https://open.spotify.com/album/4TM7wmWEakp4xk1ZffVkL8"
                  },
                  "href": "https://api.spotify.com/v1/albums/4TM7wmWEakp4xk1ZffVkL8",
                  "id": "4TM7wmWEakp4xk1ZffVkL8",
                  "images": [
                      {
                          "height": 640,
                          "url": "https://i.scdn.co/image/ab67616d0000b273a04217690839e605a310009c",
                          "width": 640
                      },
                      {
                          "height": 300,
                          "url": "https://i.scdn.co/image/ab67616d00001e02a04217690839e605a310009c",
                          "width": 300
                      },
                      {
                          "height": 64,
                          "url": "https://i.scdn.co/image/ab67616d00004851a04217690839e605a310009c",
                          "width": 64
                      }
                  ],
                  "name": "Together",
                  "release_date": "2020-05-20",
                  "release_date_precision": "day",
                  "total_tracks": 1,
                  "type": "album",
                  "uri": "spotify:album:4TM7wmWEakp4xk1ZffVkL8"
              },
              {
                  "album_type": "single",
                  "artists": [
                      {
                          "external_urls": {
                              "spotify": "https://open.spotify.com/artist/2YIHuXM9ivsh3cGQ0Ne1tl"
                          },
                          "href": "https://api.spotify.com/v1/artists/2YIHuXM9ivsh3cGQ0Ne1tl",
                          "id": "2YIHuXM9ivsh3cGQ0Ne1tl",
                          "name": "Pragnya Wakhlu",
                          "type": "artist",
                          "uri": "spotify:artist:2YIHuXM9ivsh3cGQ0Ne1tl"
                      }
                  ],
                  "available_markets": [
                      "AD",
                      "AE",
                      "AL",
                      "AR",
                      "AT",
                      "AU",
                      "BA",
                      "BE",
                      "BG",
                      "BH",
                      "BO",
                      "BR",
                      "BY",
                      "CA",
                      "CH",
                      "CL",
                      "CO",
                      "CR",
                      "CY",
                      "CZ",
                      "DE",
                      "DK",
                      "DO",
                      "DZ",
                      "EC",
                      "EE",
                      "EG",
                      "ES",
                      "FI",
                      "FR",
                      "GB",
                      "GR",
                      "GT",
                      "HK",
                      "HN",
                      "HR",
                      "HU",
                      "ID",
                      "IE",
                      "IL",
                      "IN",
                      "IS",
                      "IT",
                      "JO",
                      "JP",
                      "KW",
                      "KZ",
                      "LB",
                      "LI",
                      "LT",
                      "LU",
                      "LV",
                      "MA",
                      "MC",
                      "MD",
                      "ME",
                      "MK",
                      "MT",
                      "MX",
                      "MY",
                      "NI",
                      "NL",
                      "NO",
                      "NZ",
                      "OM",
                      "PA",
                      "PE",
                      "PH",
                      "PL",
                      "PS",
                      "PT",
                      "PY",
                      "QA",
                      "RO",
                      "RS",
                      "RU",
                      "SA",
                      "SE",
                      "SG",
                      "SI",
                      "SK",
                      "SV",
                      "TH",
                      "TN",
                      "TR",
                      "TW",
                      "UA",
                      "US",
                      "UY",
                      "VN",
                      "XK",
                      "ZA"
                  ],
                  "external_urls": {
                      "spotify": "https://open.spotify.com/album/6qzqdF70CUHrHJoy2cltgQ"
                  },
                  "href": "https://api.spotify.com/v1/albums/6qzqdF70CUHrHJoy2cltgQ",
                  "id": "6qzqdF70CUHrHJoy2cltgQ",
                  "images": [
                      {
                          "height": 640,
                          "url": "https://i.scdn.co/image/ab67616d0000b273241032d88963ab471a63cd67",
                          "width": 640
                      },
                      {
                          "height": 300,
                          "url": "https://i.scdn.co/image/ab67616d00001e02241032d88963ab471a63cd67",
                          "width": 300
                      },
                      {
                          "height": 64,
                          "url": "https://i.scdn.co/image/ab67616d00004851241032d88963ab471a63cd67",
                          "width": 64
                      }
                  ],
                  "name": "Fallin'",
                  "release_date": "2020-05-17",
                  "release_date_precision": "day",
                  "total_tracks": 1,
                  "type": "album",
                  "uri": "spotify:album:6qzqdF70CUHrHJoy2cltgQ"
              },
              {
                  "album_type": "album",
                  "artists": [
                      {
                          "external_urls": {
                              "spotify": "https://open.spotify.com/artist/25uiPmTg16RbhZWAqwLBy5"
                          },
                          "href": "https://api.spotify.com/v1/artists/25uiPmTg16RbhZWAqwLBy5",
                          "id": "25uiPmTg16RbhZWAqwLBy5",
                          "name": "Charli XCX",
                          "type": "artist",
                          "uri": "spotify:artist:25uiPmTg16RbhZWAqwLBy5"
                      }
                  ],
                  "available_markets": [
                      "AD",
                      "AE",
                      "AL",
                      "AR",
                      "AT",
                      "AU",
                      "BA",
                      "BE",
                      "BG",
                      "BH",
                      "BO",
                      "BR",
                      "BY",
                      "CA",
                      "CH",
                      "CL",
                      "CO",
                      "CR",
                      "CY",
                      "CZ",
                      "DE",
                      "DK",
                      "DO",
                      "DZ",
                      "EC",
                      "EE",
                      "EG",
                      "ES",
                      "FI",
                      "FR",
                      "GB",
                      "GR",
                      "GT",
                      "HK",
                      "HN",
                      "HR",
                      "HU",
                      "ID",
                      "IE",
                      "IL",
                      "IN",
                      "IS",
                      "IT",
                      "JO",
                      "JP",
                      "KW",
                      "KZ",
                      "LB",
                      "LI",
                      "LT",
                      "LU",
                      "LV",
                      "MA",
                      "MC",
                      "MD",
                      "ME",
                      "MK",
                      "MT",
                      "MX",
                      "MY",
                      "NI",
                      "NL",
                      "NO",
                      "NZ",
                      "OM",
                      "PA",
                      "PE",
                      "PH",
                      "PL",
                      "PS",
                      "PT",
                      "PY",
                      "QA",
                      "RO",
                      "RS",
                      "RU",
                      "SA",
                      "SE",
                      "SG",
                      "SI",
                      "SK",
                      "SV",
                      "TH",
                      "TN",
                      "TR",
                      "TW",
                      "UA",
                      "US",
                      "UY",
                      "VN",
                      "XK",
                      "ZA"
                  ],
                  "external_urls": {
                      "spotify": "https://open.spotify.com/album/3a9qH2VEsSiOZvMrjaS0Nu"
                  },
                  "href": "https://api.spotify.com/v1/albums/3a9qH2VEsSiOZvMrjaS0Nu",
                  "id": "3a9qH2VEsSiOZvMrjaS0Nu",
                  "images": [
                      {
                          "height": 640,
                          "url": "https://i.scdn.co/image/ab67616d0000b273664e38c99d077cc52ab48914",
                          "width": 640
                      },
                      {
                          "height": 300,
                          "url": "https://i.scdn.co/image/ab67616d00001e02664e38c99d077cc52ab48914",
                          "width": 300
                      },
                      {
                          "height": 64,
                          "url": "https://i.scdn.co/image/ab67616d00004851664e38c99d077cc52ab48914",
                          "width": 64
                      }
                  ],
                  "name": "how i'm feeling now",
                  "release_date": "2020-05-15",
                  "release_date_precision": "day",
                  "total_tracks": 11,
                  "type": "album",
                  "uri": "spotify:album:3a9qH2VEsSiOZvMrjaS0Nu"
              }
          ],
          "limit": 20,
          "next": "https://api.spotify.com/v1/browse/new-releases?country=IN&offset=20&limit=20",
          "offset": 0,
          "previous": null,
          "total": 100
      }
    };
    service.getNewReleases().subscribe(response => {
      expect(testData).toBe(response, 'should check the mock data');
    });

    const req = httpTestController.expectOne('https://api.spotify.com/v1/browse/new-releases?country=IN');

    expect(req.cancelled).toBeFalsy();
    expect(req.request.responseType).toEqual('json');

    req.flush(testData);
  });

  it('should test get featured playlists method', () => {
    const testData: Object = 
    {
      "message": "Editor's picks",
      "playlists": {
          "href": "https://api.spotify.com/v1/browse/featured-playlists?country=IN&timestamp=2020-11-12T17%3A47%3A42&offset=0&limit=20",
          "items": [
              {
                  "collaborative": false,
                  "description": "Where Bollywood meets the hood. Cover: Badshah",
                  "external_urls": {
                      "spotify": "https://open.spotify.com/playlist/37i9dQZF1DWU2tlzlUMZTA"
                  },
                  "href": "https://api.spotify.com/v1/playlists/37i9dQZF1DWU2tlzlUMZTA",
                  "id": "37i9dQZF1DWU2tlzlUMZTA",
                  "images": [
                      {
                          "height": null,
                          "url": "https://i.scdn.co/image/ab67706f00000003d624ceed3a2cc0c89df10ecf",
                          "width": null
                      }
                  ],
                  "name": "Bollyhood",
                  "owner": {
                      "display_name": "Spotify",
                      "external_urls": {
                          "spotify": "https://open.spotify.com/user/spotify"
                      },
                      "href": "https://api.spotify.com/v1/users/spotify",
                      "id": "spotify",
                      "type": "user",
                      "uri": "spotify:user:spotify"
                  },
                  "primary_color": null,
                  "public": null,
                  "snapshot_id": "MTU5Njc4MTY3NywwMDAwMDAxMjAwMDAwMTczYzc5YWNiNWUwMDAwMDE3M2M3OWFhYjNh",
                  "tracks": {
                      "href": "https://api.spotify.com/v1/playlists/37i9dQZF1DWU2tlzlUMZTA/tracks",
                      "total": 41
                  },
                  "type": "playlist",
                  "uri": "spotify:playlist:37i9dQZF1DWU2tlzlUMZTA"
              },
              {
                  "collaborative": false,
                  "description": "Catch all the collaborations and crossover in Punjabi music. Cover: Guru Randhawa",
                  "external_urls": {
                      "spotify": "https://open.spotify.com/playlist/37i9dQZF1DWVDCraF986xg"
                  },
                  "href": "https://api.spotify.com/v1/playlists/37i9dQZF1DWVDCraF986xg",
                  "id": "37i9dQZF1DWVDCraF986xg",
                  "images": [
                      {
                          "height": null,
                          "url": "https://i.scdn.co/image/ab67706f0000000396ca560e0770ee5d4fb798dd",
                          "width": null
                      }
                  ],
                  "name": "Punjabi X",
                  "owner": {
                      "display_name": "Spotify",
                      "external_urls": {
                          "spotify": "https://open.spotify.com/user/spotify"
                      },
                      "href": "https://api.spotify.com/v1/users/spotify",
                      "id": "spotify",
                      "type": "user",
                      "uri": "spotify:user:spotify"
                  },
                  "primary_color": null,
                  "public": null,
                  "snapshot_id": "MTYwNTA4NDAzNywwMDAwMDAzYjAwMDAwMTc1YjY3NmJmZGUwMDAwMDE2ZmE4YzI0MGQ2",
                  "tracks": {
                      "href": "https://api.spotify.com/v1/playlists/37i9dQZF1DWVDCraF986xg/tracks",
                      "total": 52
                  },
                  "type": "playlist",
                  "uri": "spotify:playlist:37i9dQZF1DWVDCraF986xg"
              },
              {
                  "collaborative": false,
                  "description": "Foot tapping Telugu party hits\nCover : Allu Arjun",
                  "external_urls": {
                      "spotify": "https://open.spotify.com/playlist/37i9dQZF1DWZdcdjsv83gQ"
                  },
                  "href": "https://api.spotify.com/v1/playlists/37i9dQZF1DWZdcdjsv83gQ",
                  "id": "37i9dQZF1DWZdcdjsv83gQ",
                  "images": [
                      {
                          "height": null,
                          "url": "https://i.scdn.co/image/ab67706f00000003f1e1f2d12b949224de509e57",
                          "width": null
                      }
                  ],
                  "name": "Telugu Party Time",
                  "owner": {
                      "display_name": "Spotify",
                      "external_urls": {
                          "spotify": "https://open.spotify.com/user/spotify"
                      },
                      "href": "https://api.spotify.com/v1/users/spotify",
                      "id": "spotify",
                      "type": "user",
                      "uri": "spotify:user:spotify"
                  },
                  "primary_color": null,
                  "public": null,
                  "snapshot_id": "MTYwMzM1MzA5MiwwMDAwMDAyMjAwMDAwMTc1NGY0YWEyMjMwMDAwMDE2ZTZlMjY1NmJm",
                  "tracks": {
                      "href": "https://api.spotify.com/v1/playlists/37i9dQZF1DWZdcdjsv83gQ/tracks",
                      "total": 66
                  },
                  "type": "playlist",
                  "uri": "spotify:playlist:37i9dQZF1DWZdcdjsv83gQ"
              },
              {
                  "collaborative": false,
                  "description": "Time for your favorite pop tracks. Cover: BTS",
                  "external_urls": {
                      "spotify": "https://open.spotify.com/playlist/37i9dQZF1DX1dCsSMSXSsP"
                  },
                  "href": "https://api.spotify.com/v1/playlists/37i9dQZF1DX1dCsSMSXSsP",
                  "id": "37i9dQZF1DX1dCsSMSXSsP",
                  "images": [
                      {
                          "height": null,
                          "url": "https://i.scdn.co/image/ab67706f000000034f280543aaff3eac00f77154",
                          "width": null
                      }
                  ],
                  "name": "Pop Shots",
                  "owner": {
                      "display_name": "Spotify",
                      "external_urls": {
                          "spotify": "https://open.spotify.com/user/spotify"
                      },
                      "href": "https://api.spotify.com/v1/users/spotify",
                      "id": "spotify",
                      "type": "user",
                      "uri": "spotify:user:spotify"
                  },
                  "primary_color": null,
                  "public": null,
                  "snapshot_id": "MTYwNDM4OTU0NSwwMDAwMDA0YzAwMDAwMTc1OGQxMWE1ZTEwMDAwMDE3NDQzNWJlN2I3",
                  "tracks": {
                      "href": "https://api.spotify.com/v1/playlists/37i9dQZF1DX1dCsSMSXSsP/tracks",
                      "total": 72
                  },
                  "type": "playlist",
                  "uri": "spotify:playlist:37i9dQZF1DX1dCsSMSXSsP"
              },
              {
                  "collaborative": false,
                  "description": "Fast-paced tunes for Tamil party time!\nCover : Prabhu Deva",
                  "external_urls": {
                      "spotify": "https://open.spotify.com/playlist/37i9dQZF1DX0nA91dV2ts4"
                  },
                  "href": "https://api.spotify.com/v1/playlists/37i9dQZF1DX0nA91dV2ts4",
                  "id": "37i9dQZF1DX0nA91dV2ts4",
                  "images": [
                      {
                          "height": null,
                          "url": "https://i.scdn.co/image/ab67706f0000000342abbf69840a15e7a8a9c7b7",
                          "width": null
                      }
                  ],
                  "name": "Tamil Party Time",
                  "owner": {
                      "display_name": "Spotify",
                      "external_urls": {
                          "spotify": "https://open.spotify.com/user/spotify"
                      },
                      "href": "https://api.spotify.com/v1/users/spotify",
                      "id": "spotify",
                      "type": "user",
                      "uri": "spotify:user:spotify"
                  },
                  "primary_color": null,
                  "public": null,
                  "snapshot_id": "MTYwMzI3NzAxNywwMDAwMDAxOTAwMDAwMTc1NGFjMWQyNjgwMDAwMDE2ZTZlODMwMDc3",
                  "tracks": {
                      "href": "https://api.spotify.com/v1/playlists/37i9dQZF1DX0nA91dV2ts4/tracks",
                      "total": 102
                  },
                  "type": "playlist",
                  "uri": "spotify:playlist:37i9dQZF1DX0nA91dV2ts4"
              },
              {
                  "collaborative": false,
                  "description": "Best of the Jazz music scene in India.",
                  "external_urls": {
                      "spotify": "https://open.spotify.com/playlist/37i9dQZF1DX8G6uERfhfPM"
                  },
                  "href": "https://api.spotify.com/v1/playlists/37i9dQZF1DX8G6uERfhfPM",
                  "id": "37i9dQZF1DX8G6uERfhfPM",
                  "images": [
                      {
                          "height": null,
                          "url": "https://i.scdn.co/image/ab67706f0000000342929b931509b891d5c54bde",
                          "width": null
                      }
                  ],
                  "name": "Jazz in India",
                  "owner": {
                      "display_name": "Spotify",
                      "external_urls": {
                          "spotify": "https://open.spotify.com/user/spotify"
                      },
                      "href": "https://api.spotify.com/v1/users/spotify",
                      "id": "spotify",
                      "type": "user",
                      "uri": "spotify:user:spotify"
                  },
                  "primary_color": null,
                  "public": null,
                  "snapshot_id": "MTYwMzk0OTUxNywwMDAwMDAxMzAwMDAwMTc1NzJkNzVjMGQwMDAwMDE3MjMxY2FiMzM0",
                  "tracks": {
                      "href": "https://api.spotify.com/v1/playlists/37i9dQZF1DX8G6uERfhfPM/tracks",
                      "total": 50
                  },
                  "type": "playlist",
                  "uri": "spotify:playlist:37i9dQZF1DX8G6uERfhfPM"
              },
              {
                  "collaborative": false,
                  "description": "Get in for a musical commute",
                  "external_urls": {
                      "spotify": "https://open.spotify.com/playlist/37i9dQZF1DWVDvBpGQbzXj"
                  },
                  "href": "https://api.spotify.com/v1/playlists/37i9dQZF1DWVDvBpGQbzXj",
                  "id": "37i9dQZF1DWVDvBpGQbzXj",
                  "images": [
                      {
                          "height": null,
                          "url": "https://i.scdn.co/image/ab67706f00000003a568f63ec0f9fd2695695f26",
                          "width": null
                      }
                  ],
                  "name": "Music Shuttle",
                  "owner": {
                      "display_name": "Spotify",
                      "external_urls": {
                          "spotify": "https://open.spotify.com/user/spotify"
                      },
                      "href": "https://api.spotify.com/v1/users/spotify",
                      "id": "spotify",
                      "type": "user",
                      "uri": "spotify:user:spotify"
                  },
                  "primary_color": null,
                  "public": null,
                  "snapshot_id": "MTYwMjgyNzUwNCwwMDAwMDAzNzAwMDAwMTc1MmZmNmNiMGEwMDAwMDE3MGFmMzFlYzE4",
                  "tracks": {
                      "href": "https://api.spotify.com/v1/playlists/37i9dQZF1DWVDvBpGQbzXj/tracks",
                      "total": 78
                  },
                  "type": "playlist",
                  "uri": "spotify:playlist:37i9dQZF1DWVDvBpGQbzXj"
              },
              {
                  "collaborative": false,
                  "description": "This is how we do it, This is our style.\nCover: Sidhu Moose Wala",
                  "external_urls": {
                      "spotify": "https://open.spotify.com/playlist/37i9dQZF1DWTqYqGLu7kTX"
                  },
                  "href": "https://api.spotify.com/v1/playlists/37i9dQZF1DWTqYqGLu7kTX",
                  "id": "37i9dQZF1DWTqYqGLu7kTX",
                  "images": [
                      {
                          "height": null,
                          "url": "https://i.scdn.co/image/ab67706f00000003ffc809a7d98e0bb4065bf21e",
                          "width": null
                      }
                  ],
                  "name": "Hip Te Hop",
                  "owner": {
                      "display_name": "Spotify",
                      "external_urls": {
                          "spotify": "https://open.spotify.com/user/spotify"
                      },
                      "href": "https://api.spotify.com/v1/users/spotify",
                      "id": "spotify",
                      "type": "user",
                      "uri": "spotify:user:spotify"
                  },
                  "primary_color": null,
                  "public": null,
                  "snapshot_id": "MTYwNDcyNzQzNSwwMDAwMDEyNDAwMDAwMTc1YTEzNTZmZjgwMDAwMDE3NTRlYmE1NDc5",
                  "tracks": {
                      "href": "https://api.spotify.com/v1/playlists/37i9dQZF1DWTqYqGLu7kTX/tracks",
                      "total": 96
                  },
                  "type": "playlist",
                  "uri": "spotify:playlist:37i9dQZF1DWTqYqGLu7kTX"
              },
              {
                  "collaborative": false,
                  "description": "Best Romantic songs from 90s\nCover : Rajnikanth - Shobana",
                  "external_urls": {
                      "spotify": "https://open.spotify.com/playlist/37i9dQZF1DWY7EoqMbT7wZ"
                  },
                  "href": "https://api.spotify.com/v1/playlists/37i9dQZF1DWY7EoqMbT7wZ",
                  "id": "37i9dQZF1DWY7EoqMbT7wZ",
                  "images": [
                      {
                          "height": null,
                          "url": "https://i.scdn.co/image/ab67706f0000000360ed10007f5a5339e5d0be8a",
                          "width": null
                      }
                  ],
                  "name": "90s Romance Tamil",
                  "owner": {
                      "display_name": "Spotify",
                      "external_urls": {
                          "spotify": "https://open.spotify.com/user/spotify"
                      },
                      "href": "https://api.spotify.com/v1/users/spotify",
                      "id": "spotify",
                      "type": "user",
                      "uri": "spotify:user:spotify"
                  },
                  "primary_color": null,
                  "public": null,
                  "snapshot_id": "MTYwMzM0OTMwNSwwMDAwMDAwNDAwMDAwMTc1NGYxMGQ5ZGMwMDAwMDE3MjlkZTMxMTEz",
                  "tracks": {
                      "href": "https://api.spotify.com/v1/playlists/37i9dQZF1DWY7EoqMbT7wZ/tracks",
                      "total": 107
                  },
                  "type": "playlist",
                  "uri": "spotify:playlist:37i9dQZF1DWY7EoqMbT7wZ"
              },
              {
                  "collaborative": false,
                  "description": "Best of 90s from Tollywood\nCover : Nagarjuna",
                  "external_urls": {
                      "spotify": "https://open.spotify.com/playlist/37i9dQZF1DX5EEpa9ekxRI"
                  },
                  "href": "https://api.spotify.com/v1/playlists/37i9dQZF1DX5EEpa9ekxRI",
                  "id": "37i9dQZF1DX5EEpa9ekxRI",
                  "images": [
                      {
                          "height": null,
                          "url": "https://i.scdn.co/image/ab67706f00000003e056edc9faddd4f448e29d62",
                          "width": null
                      }
                  ],
                  "name": "All Out 90s Telugu",
                  "owner": {
                      "display_name": "Spotify",
                      "external_urls": {
                          "spotify": "https://open.spotify.com/user/spotify"
                      },
                      "href": "https://api.spotify.com/v1/users/spotify",
                      "id": "spotify",
                      "type": "user",
                      "uri": "spotify:user:spotify"
                  },
                  "primary_color": null,
                  "public": null,
                  "snapshot_id": "MTYwMzM0ODI0OCwwMDAwMDAwNDAwMDAwMTc1NGYwMGI3MTkwMDAwMDE3Mjk5MTZiYzQ3",
                  "tracks": {
                      "href": "https://api.spotify.com/v1/playlists/37i9dQZF1DX5EEpa9ekxRI/tracks",
                      "total": 123
                  },
                  "type": "playlist",
                  "uri": "spotify:playlist:37i9dQZF1DX5EEpa9ekxRI"
              },
              {
                  "collaborative": false,
                  "description": "Enjoy Coin free!",
                  "external_urls": {
                      "spotify": "https://open.spotify.com/playlist/37i9dQZF1DX5HjYnbxXZwh"
                  },
                  "href": "https://api.spotify.com/v1/playlists/37i9dQZF1DX5HjYnbxXZwh",
                  "id": "37i9dQZF1DX5HjYnbxXZwh",
                  "images": [
                      {
                          "height": null,
                          "url": "https://i.scdn.co/image/ab67706f0000000347c8211accd028551f7d9d30",
                          "width": null
                      }
                  ],
                  "name": "Punjabi Jukebox",
                  "owner": {
                      "display_name": "Spotify",
                      "external_urls": {
                          "spotify": "https://open.spotify.com/user/spotify"
                      },
                      "href": "https://api.spotify.com/v1/users/spotify",
                      "id": "spotify",
                      "type": "user",
                      "uri": "spotify:user:spotify"
                  },
                  "primary_color": null,
                  "public": null,
                  "snapshot_id": "MTU4ODYxMzMyNCwwMDAwMDAwODAwMDAwMTcxZTBiYjlmZjkwMDAwMDE3MGM0YTlkNWFl",
                  "tracks": {
                      "href": "https://api.spotify.com/v1/playlists/37i9dQZF1DX5HjYnbxXZwh/tracks",
                      "total": 34
                  },
                  "type": "playlist",
                  "uri": "spotify:playlist:37i9dQZF1DX5HjYnbxXZwh"
              },
              {
                  "collaborative": false,
                  "description": "Bubbling under today, stars of tomorrow. Stream Taba Chake's latest single NOW!",
                  "external_urls": {
                      "spotify": "https://open.spotify.com/playlist/37i9dQZF1DWTAtTdFMiJYK"
                  },
                  "href": "https://api.spotify.com/v1/playlists/37i9dQZF1DWTAtTdFMiJYK",
                  "id": "37i9dQZF1DWTAtTdFMiJYK",
                  "images": [
                      {
                          "height": null,
                          "url": "https://i.scdn.co/image/ab67706f00000003df486cd0abf7548f2771442a",
                          "width": null
                      }
                  ],
                  "name": "Radar India",
                  "owner": {
                      "display_name": "Spotify",
                      "external_urls": {
                          "spotify": "https://open.spotify.com/user/spotify"
                      },
                      "href": "https://api.spotify.com/v1/users/spotify",
                      "id": "spotify",
                      "type": "user",
                      "uri": "spotify:user:spotify"
                  },
                  "primary_color": null,
                  "public": null,
                  "snapshot_id": "MTYwNTE2OTc4NSwwMDAwMDEzNDAwMDAwMTc1YmI5MzI5OGQwMDAwMDE3NWFlNzVmNzAz",
                  "tracks": {
                      "href": "https://api.spotify.com/v1/playlists/37i9dQZF1DWTAtTdFMiJYK/tracks",
                      "total": 102
                  },
                  "type": "playlist",
                  "uri": "spotify:playlist:37i9dQZF1DWTAtTdFMiJYK"
              },
              {
                  "collaborative": false,
                  "description": "Explore the folk side of Tamil Indie\nCover : Anthony Dassan",
                  "external_urls": {
                      "spotify": "https://open.spotify.com/playlist/37i9dQZF1DX4LtwzJ5HQFk"
                  },
                  "href": "https://api.spotify.com/v1/playlists/37i9dQZF1DX4LtwzJ5HQFk",
                  "id": "37i9dQZF1DX4LtwzJ5HQFk",
                  "images": [
                      {
                          "height": null,
                          "url": "https://i.scdn.co/image/ab67706f00000003683cd22bd8cbdde92da74605",
                          "width": null
                      }
                  ],
                  "name": "Indie Folk",
                  "owner": {
                      "display_name": "Spotify",
                      "external_urls": {
                          "spotify": "https://open.spotify.com/user/spotify"
                      },
                      "href": "https://api.spotify.com/v1/users/spotify",
                      "id": "spotify",
                      "type": "user",
                      "uri": "spotify:user:spotify"
                  },
                  "primary_color": null,
                  "public": null,
                  "snapshot_id": "MTYwMTkwMDU0NiwwMDAwMDAwYjAwMDAwMTc0ZjhiNjhhZGQwMDAwMDE2ZjEzNGRmODg1",
                  "tracks": {
                      "href": "https://api.spotify.com/v1/playlists/37i9dQZF1DX4LtwzJ5HQFk/tracks",
                      "total": 51
                  },
                  "type": "playlist",
                  "uri": "spotify:playlist:37i9dQZF1DX4LtwzJ5HQFk"
              }
          ],
          "limit": 20,
          "next": null,
          "offset": 0,
          "previous": null,
          "total": 13
      }
    };
    service.getFeauredPlayLists().subscribe( response => {
      expect(testData).toBe(response, 'should check the mock data');
    });

    const req = httpTestController.expectOne('https://api.spotify.com/v1/browse/featured-playlists?country=IN');

    expect(req.cancelled).toBeFalsy();
    expect(req.request.responseType).toEqual('json');

    req.flush(testData);
  });
});
