export interface ListingsModel {
    title: string;
    description: string;
    rent: number;
    bedrooms: number;
    bathrooms: number;
    address: string;
    amenities: string;
    photos: URL;
    available: boolean;
}