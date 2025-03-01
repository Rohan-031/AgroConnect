import Navbar from './Navbar';
import Footer from './Footer';
import { ShoppingBasket, Truck, Users } from 'lucide-react';

export default function LandingPage() {
  return (
    <div className="flex min-h-screen flex-col">
      <Navbar />

      <main className="flex-1 pt-16">
        {/* Hero Section */}
        <section className="w-full py-12 md:py-24 bg-gradient-to-b from-green-50 to-green-100">
          <div className="container mx-auto px-4 md:px-6">
            <div className="grid gap-6 lg:grid-cols-[1fr_400px] lg:gap-12">
              <div className="flex flex-col justify-center space-y-4">
                <h1 className="text-3xl font-bold tracking-tighter sm:text-5xl">
                  Connecting Farmers to Consumers
                </h1>
                <p className="max-w-[600px] text-gray-500 md:text-xl">
                  Empowering farmers and providing fresh produce directly to consumers.
                </p>
                <div className="flex flex-col gap-2 min-[400px]:flex-row">
                  <button className="bg-green-600 hover:bg-green-700 text-white py-2 px-4 rounded-md">
                    Join Us
                  </button>
                  <button className="border border-green-600 text-green-600 py-2 px-4 rounded-md">
                    Learn More
                  </button>
                </div>
              </div>
              <div className="flex items-center justify-center">
                <img
                  src="https://media.licdn.com/dms/image/v2/C4E0BAQFeXsCRtr5DjQ/company-logo_200_200/company-logo_200_200/0/1630578100174/agro_connect_nig_logo?e=2147483647&v=beta&t=1Dsq-RVJ6oxrLn1kgY1V8MipLnQvcBl3Nt2RLyAShkk"
                  alt="AgroConnect App"
                  className="object-cover rounded-xl shadow-2xl max-w-[350px] max-h-[700px]"
                />
              </div>
            </div>
          </div>
        </section>

        {/* Features Section */}
        <section id="features" className="w-full py-12 md:py-24 bg-white">
          <div className="container mx-auto px-4 md:px-6">
            <h2 className="text-3xl font-bold tracking-tighter text-center sm:text-4xl mb-8">
              Key Features
            </h2>
            <div className="grid gap-8 md:grid-cols-3">
              {[
                {
                  icon: <ShoppingBasket className="h-12 w-12 text-green-600 mb-4" />,
                  title: 'Direct Marketplace',
                  description: 'Buy and sell farm products directly without middlemen.',
                },
                {
                  icon: <Truck className="h-12 w-12 text-green-600 mb-4" />,
                  title: 'Efficient Logistics',
                  description: 'Reliable and fast delivery of fresh produce.',
                },
                {
                  icon: <Users className="h-12 w-12 text-green-600 mb-4" />,
                  title: 'Community Support',
                  description: 'Engage with a community of farmers and consumers.',
                },
              ].map((feature, index) => (
                <div key={index} className="flex flex-col items-center text-center">
                  {feature.icon}
                  <h3 className="text-xl font-bold mb-2">{feature.title}</h3>
                  <p className="text-gray-500">{feature.description}</p>
                </div>
              ))}
            </div>
          </div>
        </section>
      </main>

      <Footer />
    </div>
  );
}
