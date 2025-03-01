import { Facebook, Instagram, Twitter } from 'lucide-react';

export default function Footer() {
  return (
    <footer className="bg-green-600 text-white py-4">
      <div className="container mx-auto px-4 flex flex-col items-center md:flex-row md:justify-between">
        <div className="text-center md:text-left mb-4 md:mb-0">
          <h3 className="text-xl font-bold">AgroConnect</h3>
          <p className="text-sm">Connecting Farmers to Markets</p>
        </div>
        <div className="flex gap-4">
          <a href="#" aria-label="Facebook">
            <Facebook className="h-5 w-5 hover:text-gray-300" />
          </a>
          <a href="#" aria-label="Instagram">
            <Instagram className="h-5 w-5 hover:text-gray-300" />
          </a>
          <a href="#" aria-label="Twitter">
            <Twitter className="h-5 w-5 hover:text-gray-300" />
          </a>
        </div>
      </div>
    </footer>
  );
}
