const API_URL = 'http://localhost:8080/api';

// Handle Login
if (document.getElementById('login-form')) {
    document.getElementById('login-form').addEventListener('submit', async (e) => {
        e.preventDefault();
        
        const email = document.getElementById('email').value;
        const password = document.getElementById('password').value;
        
        try {
            const response = await fetch(`${API_URL}/auth/login`, {
                method: 'POST',
                headers: {
                    'Content-Type': 'application/json'
                },
                body: JSON.stringify({ email, password })
            });
            
            const data = await response.json();
            
            if (data.success) {
                // Save user data to localStorage
                localStorage.setItem('token', data.data.token);
                localStorage.setItem('user', JSON.stringify(data.data));
                
                showSuccess('Login successful! Redirecting...');
                setTimeout(() => {
                    window.location.href = '../index.html';
                }, 1500);
            } else {
                showError(data.message);
            }
        } catch (error) {
            showError('Login failed. Please try again.');
            console.error('Error:', error);
        }
    });
}

// Handle Registration
if (document.getElementById('register-form')) {
    document.getElementById('register-form').addEventListener('submit', async (e) => {
        e.preventDefault();
        
        const name = document.getElementById('name').value;
        const email = document.getElementById('email').value;
        const password = document.getElementById('password').value;
        const phone = document.getElementById('phone').value;
        const address = document.getElementById('address').value;
        
        try {
            const response = await fetch(`${API_URL}/auth/register`, {
                method: 'POST',
                headers: {
                    'Content-Type': 'application/json'
                },
                body: JSON.stringify({
                    name,
                    email,
                    password,
                    phone,
                    address,
                    role: 'CUSTOMER'
                })
            });
            
            const data = await response.json();
            
            if (data.success) {
                // Save user data to localStorage
                localStorage.setItem('token', data.data.token);
                localStorage.setItem('user', JSON.stringify(data.data));
                
                showSuccess('Registration successful! Redirecting...');
                setTimeout(() => {
                    window.location.href = '../index.html';
                }, 1500);
            } else {
                showError(data.message);
            }
        } catch (error) {
            showError('Registration failed. Please try again.');
            console.error('Error:', error);
        }
    });
}

function showError(message) {
    const errorDiv = document.getElementById('error-message');
    errorDiv.textContent = message;
    errorDiv.style.display = 'block';
    setTimeout(() => {
        errorDiv.style.display = 'none';
    }, 5000);
}

function showSuccess(message) {
    const successDiv = document.getElementById('success-message');
    successDiv.textContent = message;
    successDiv.style.display = 'block';
    setTimeout(() => {
        successDiv.style.display = 'none';
    }, 5000);
}