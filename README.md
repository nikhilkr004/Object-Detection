Object Detection Android App
A real-time object detection Android application that uses TensorFlow Lite and CameraX to detect objects through the device camera and display bounding boxes with labels.

📱 App Overview
![image alt](https://github.com/nikhilkr004/Object-Detection/blob/master/Screenshot%202025-09-13%20195750.png)
![image alt](https://github.com/nikhilkr004/Object-Detection/blob/master/Screenshot%202025-09-13%20195705.png)
![image alt](https://github.com/nikhilkr004/Object-Detection/blob/master/Screenshot%202025-09-13%20195626.png)

✨ Features
Real-time Object Detection: Detect objects in real-time using device camera

Bounding Boxes: Visual bounding boxes around detected objects

Multi-color Boxes: Different colors for different objects

Confidence Scores: Display detection confidence percentages

Camera Switching: Switch between front and rear cameras

Modern Android Development: Built with Kotlin, CameraX, and TensorFlow Lite

🛠️ Technologies Used
Core Technologies
Kotlin - Programming language

Android Jetpack Components:

CameraX - Camera API for image capture and analysis

ViewBinding - Type-safe view references

Lifecycle-aware components - Proper lifecycle management

Machine Learning
TensorFlow Lite - On-device ML inference

TFLite Task Library - Pre-built vision tasks

Custom Object Detection Model - Pre-trained detection model

UI Components
PreviewView - Camera preview surface

Custom View - For drawing bounding boxes

Material Design Components - Modern UI elements

📋 Prerequisites
Android Studio (Arctic Fox or newer)

Android device with camera or emulator with camera support

Minimum SDK: 24 (Android 7.0)

Target SDK: 34 (Android 14)

🔧 Installation
Clone the repository

bash
git clone https://github.com/yourusername/object-detection-app.git
Open in Android Studio

Open Android Studio

Select "Open an existing project"

Navigate to the cloned directory

Add Model Files

Place your model.tflite file in app/src/main/assets/

Create a labels.txt file with class names (optional)

Build and Run

Connect your Android device or start an emulator

Click "Run" in Android Studio

📁 Project Structure
text
app/
├── src/
│   ├── main/
│   │   ├── assets/
│   │   │   ├── model.tflite          # TensorFlow Lite model
│   │   │   └── labels.txt            # Object class labels (optional)
│   │   ├── java/
│   │   │   └── com/example/objectdetection/
│   │   │       ├── MainActivity.kt   # Main activity with camera logic
│   │   │       └── BoundingBoxView.kt # Custom view for drawing boxes
│   │   └── res/
│   │       ├── layout/
│   │       │   └── activity_main.xml # Main layout file
│   │       └── values/
│   │           └── strings.xml       # String resources
│   └── build.gradle                  # App-level dependencies
└── build.gradle                      # Project-level configuration
🧩 Code Overview
MainActivity.kt
The main activity that handles:

Camera permissions and initialization

TensorFlow Lite model loading

Image analysis using CameraX

Detection results processing

BoundingBoxView.kt
Custom view that:

Draws bounding boxes around detected objects

Displays object labels with confidence scores

Uses different colors for different objects

activity_main.xml
Layout file containing:

Camera preview surface

Bounding box overlay view

Detection results text view

Camera switch button

🔌 Dependencies
gradle
dependencies {
    // TensorFlow Lite
    implementation 'org.tensorflow:tensorflow-lite:2.14.0'
    implementation 'org.tensorflow:tensorflow-lite-gpu:2.14.0'
    implementation 'org.tensorflow:tensorflow-lite-support:0.4.4'
    implementation 'org.tensorflow:tensorflow-lite-task-vision:0.4.4'
    
    // CameraX
    implementation 'androidx.camera:camera-camera2:1.3.1'
    implementation 'androidx.camera:camera-lifecycle:1.3.1'
    implementation 'androidx.camera:camera-view:1.3.1'
    
    // AndroidX
    implementation 'androidx.core:core-ktx:1.12.0'
    implementation 'androidx.appcompat:appcompat:1.6.1'
    implementation 'com.google.android.material:material:1.11.0'
    implementation 'androidx.constraintlayout:constraintlayout:2.1.4'
    
    // Lifecycle
    implementation 'androidx.lifecycle:lifecycle-runtime-ktx:2.7.0'
}
🎯 How It Works
Camera Initialization: The app requests camera permissions and initializes CameraX

Image Capture: CameraX captures frames from the camera feed

Image Conversion: Frames are converted from YUV to Bitmap format

Object Detection: TensorFlow Lite processes the image and detects objects

Result Processing: Detection results are parsed and formatted

UI Update: Bounding boxes and labels are drawn on the screen

📊 Performance Optimization
Image Resolution: Images are scaled appropriately for detection

Thread Management: Uses separate thread for image analysis

Model Optimization: Quantized TensorFlow Lite model for faster inference

Memory Management: Proper cleanup of resources to prevent leaks

🤝 Contributing
Fork the project

Create your feature branch (git checkout -b feature/AmazingFeature)

Commit your changes (git commit -m 'Add some AmazingFeature')

Push to the branch (git push origin feature/AmazingFeature)

Open a Pull Request

📝 License
This project is licensed under the MIT License - see the LICENSE.md file for details.

🙏 Acknowledgments
TensorFlow team for TensorFlow Lite

Android team for CameraX API

COCO dataset for object classes

Google ML Kit for inspiration

📚 References
TensorFlow Lite Documentation

CameraX Guide

Android Developer Documentation

COCO Dataset

🐛 Troubleshooting
Common Issues
Camera not working

Check camera permissions

Verify device has a camera

Model not loading

Ensure model.tflite is in assets folder

Check model compatibility

Bounding boxes not aligned

Check image dimensions and scaling

App crashes on detection

Verify TensorFlow Lite dependencies

Check model input/output dimensions

Getting Help
Create an issue on GitHub

Check existing issues for solutions

Refer to Android and TensorFlow documentation

📞 Contact
Name-Nikhil Kumar ,nikhilabc860@gmail.com

Project Link: https://github.com/nikhilkr004/object-detection-app
