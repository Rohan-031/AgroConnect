import { Leaf } from 'lucide-react';
import { useNavigate } from 'react-router-dom';

export default function Navbar() {
    const navigate = useNavigate();
    return (
        <header className="sticky top-0 z-40 border-b bg-white shadow-sm">
            <div className="container mx-auto flex h-16 items-center justify-between px-4">
                <div className="flex items-center gap-2">
                    <Leaf className="h-6 w-6 text-green-600" />
                    <span className="text-xl font-bold">AgroConnect</span>
                </div>
                <nav className="hidden md:flex items-center gap-6">
                </nav>
                <div className="flex gap-2">
                    <button 
                        onClick={() => navigate('/SignIn')}
                        className="bg-green-600 hover:bg-green-700 text-white py-2 px-4 rounded-md"
                    >
                        Sign In
                    </button>
                    <button className="bg-green-600 hover:bg-green-700 text-white py-2 px-4 rounded-md"
                    onClick={() => navigate('/SignUp')}>
                        Sign Up
                    </button>
                </div>
            </div>
        </header>
    );
}
