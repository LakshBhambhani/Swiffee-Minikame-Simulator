//
//  FirstViewController.swift
//  Swiffee
//
//  Created by Laksh Bhambhani on 4/30/19.
//  Copyright © 2019 Laksh Bhambhani. All rights reserved.
//

import UIKit
import WebKit

class FirstViewController: UIViewController, WKUIDelegate {
    
    var webView: WKWebView!

    let forward = UIButton()
    let stop = UIButton()
    let reverse = UIButton()
    let left = UIButton()
    let right = UIButton()
    let bow = UIButton()
    let bendBack = UIButton()
    let jumpUp = UIButton()
    let jumpBack = UIButton()
    let pushUp = UIButton()
    
    @IBOutlet weak var textField: UITextField!
    
    var botIp : String?

    
    override func viewDidLoad() {
        super.viewDidLoad()
        
        let webConfiguration = WKWebViewConfiguration()
        webView = WKWebView(frame: .init(x: 1000, y: 1000, width: 0, height: 0), configuration: webConfiguration)
        webView.uiDelegate = self
        
        textField.delegate = self as! UITextFieldDelegate

        self.view.addSubview(forward)
        self.view.addSubview(stop)
        self.view.addSubview(reverse)
        self.view.addSubview(left)
        self.view.addSubview(right)
        self.view.addSubview(bow)
        self.view.addSubview(bendBack)
        self.view.addSubview(jumpUp)
        self.view.addSubview(jumpBack)
        self.view.addSubview(pushUp)
        self.view.addSubview(textField)

        forward.setTitle("Forward", for: .normal)
        forward.setTitleColor(UIColor.blue, for: .normal)
        forward.translatesAutoresizingMaskIntoConstraints = false
        forward.rightAnchor.constraint(equalTo: view.rightAnchor, constant: -80).isActive = true
        forward.topAnchor.constraint(equalTo: view.topAnchor).isActive = true
        forward.bottomAnchor.constraint(equalTo: view.centerYAnchor, constant: -8).isActive = true
        forward.widthAnchor.constraint(equalToConstant: 100).isActive = true
        forward.heightAnchor.constraint(equalToConstant: 20).isActive = true
        forward.addTarget(self, action: #selector(forwardAction), for: .touchUpInside)
        
        reverse.setTitle("Reverse", for: .normal)
        reverse.setTitleColor(UIColor.blue, for: .normal)
        reverse.translatesAutoresizingMaskIntoConstraints = false
        reverse.topAnchor.constraint(equalTo: forward.bottomAnchor, constant: 8).isActive = true
        reverse.rightAnchor.constraint(equalTo: view.rightAnchor, constant: -80).isActive = true
        reverse.bottomAnchor.constraint(equalTo: view.bottomAnchor, constant: -8).isActive = true
        reverse.widthAnchor.constraint(equalToConstant: 100).isActive = true
        reverse.heightAnchor.constraint(equalToConstant: 20).isActive = true
        reverse.addTarget(self, action: #selector(reverseAction), for: .touchUpInside)
        
        stop.setTitle("Stop", for: .normal)
        stop.setTitleColor(UIColor.blue, for: .normal)
        stop.translatesAutoresizingMaskIntoConstraints = false
        stop.centerYAnchor.constraint(equalTo: view.centerYAnchor).isActive = true
        stop.rightAnchor.constraint(equalTo: view.rightAnchor, constant: -80).isActive = true
        stop.widthAnchor.constraint(equalToConstant: 100).isActive = true
        stop.heightAnchor.constraint(equalToConstant: 20).isActive = true
        stop.addTarget(self, action: #selector(stopAction), for: .touchUpInside)

        left.setTitle("Left", for: .normal)
        left.setTitleColor(UIColor.blue, for: .normal)
        left.translatesAutoresizingMaskIntoConstraints = false
        left.leftAnchor.constraint(equalTo: view.leftAnchor, constant: 8).isActive = true
        left.centerYAnchor.constraint(equalTo: view.centerYAnchor).isActive = true
        left.widthAnchor.constraint(equalToConstant: view.frame.size.width*3/8).isActive = true
        left.heightAnchor.constraint(equalToConstant: 20).isActive = true
        left.addTarget(self, action: #selector(leftAction), for: .touchUpInside)
        
        right.setTitle("Right", for: .normal)
        right.setTitleColor(UIColor.blue, for: .normal)
        right.translatesAutoresizingMaskIntoConstraints = false
        right.leftAnchor.constraint(equalTo: left.rightAnchor, constant: 8).isActive = true
        right.centerYAnchor.constraint(equalTo: view.centerYAnchor).isActive = true
        right.widthAnchor.constraint(equalToConstant: view.frame.size.width*3/8).isActive = true
        right.heightAnchor.constraint(equalToConstant: 20).isActive = true
        right.addTarget(self, action: #selector(rightAction), for: .touchUpInside)

        bow.setTitle("Bow", for: .normal)
        bow.setTitleColor(UIColor.blue, for: .normal)
        bow.translatesAutoresizingMaskIntoConstraints = false
        bow.leftAnchor.constraint(equalTo: view.leftAnchor, constant: 8).isActive = true
        bow.bottomAnchor.constraint(equalTo: right.topAnchor, constant: -30).isActive = true
        bow.widthAnchor.constraint(equalToConstant: view.frame.size.width*3/4).isActive = true
        bow.heightAnchor.constraint(equalToConstant: 20).isActive = true
        bow.addTarget(self, action: #selector(bowAction), for: .touchUpInside)
        
        jumpUp.setTitle("Jump Up", for: .normal)
        jumpUp.setTitleColor(UIColor.blue, for: .normal)
        jumpUp.translatesAutoresizingMaskIntoConstraints = false
        jumpUp.leftAnchor.constraint(equalTo: view.leftAnchor, constant: 8).isActive = true
        jumpUp.bottomAnchor.constraint(equalTo: bow.topAnchor, constant: -30).isActive = true
        jumpUp.widthAnchor.constraint(equalToConstant: view.frame.size.width*3/4).isActive = true
        jumpUp.heightAnchor.constraint(equalToConstant: 20).isActive = true
        jumpUp.addTarget(self, action: #selector(jumpUpAction), for: .touchUpInside)
        
        pushUp.setTitle("Push Up", for: .normal)
        pushUp.setTitleColor(UIColor.blue, for: .normal)
        pushUp.translatesAutoresizingMaskIntoConstraints = false
        pushUp.leftAnchor.constraint(equalTo: view.leftAnchor, constant: 8).isActive = true
        pushUp.bottomAnchor.constraint(equalTo: jumpUp.topAnchor, constant: -30).isActive = true
        pushUp.widthAnchor.constraint(equalToConstant: view.frame.size.width*3/4).isActive = true
        pushUp.heightAnchor.constraint(equalToConstant: 20).isActive = true
        pushUp.addTarget(self, action: #selector(pushUpAction), for: .touchUpInside)
        
        bendBack.setTitle("Bend Back", for: .normal)
        bendBack.setTitleColor(UIColor.blue, for: .normal)
        bendBack.translatesAutoresizingMaskIntoConstraints = false
        bendBack.leftAnchor.constraint(equalTo: view.leftAnchor, constant: 8).isActive = true
        bendBack.topAnchor.constraint(equalTo: right.bottomAnchor, constant: 20).isActive = true
        bendBack.widthAnchor.constraint(equalToConstant: view.frame.size.width*3/4).isActive = true
        bendBack.heightAnchor.constraint(equalToConstant: 20).isActive = true
        bendBack.addTarget(self, action: #selector(bendBackAction), for: .touchUpInside)

        jumpBack.setTitle("Jump Back", for: .normal)
        jumpBack.setTitleColor(UIColor.blue, for: .normal)
        jumpBack.translatesAutoresizingMaskIntoConstraints = false
        jumpBack.leftAnchor.constraint(equalTo: view.leftAnchor, constant: 8).isActive = true
        jumpBack.topAnchor.constraint(equalTo: bendBack.bottomAnchor, constant: 30).isActive = true
        jumpBack.widthAnchor.constraint(equalToConstant: view.frame.size.width*3/4).isActive = true
        jumpBack.heightAnchor.constraint(equalToConstant: 20).isActive = true
        jumpBack.addTarget(self, action: #selector(jumpBackAction), for: .touchUpInside)
        
//        let url = URL(string: object.IP);
//        let request = URLRequest(url: url!);
//        webView.load(request);
    }
   
    
    @objc func forwardAction(sender: UIButton!) {
        print("Forward Clicked")
        let url = URL(string: "http://" + textField.text! + "/walkForward");
        let request = URLRequest(url: url!);
        webView.load(request);
        print(url!)
        
    }
    
    @objc func stopAction(sender: UIButton!) {
        print("Stop Clicked")
        let url = URL(string: "http://" + textField.text! + "/homePos");
        let request = URLRequest(url: url!);
        webView.load(request);
        print(url)
    }
    
    @objc func reverseAction(sender: UIButton!) {
        print("Reverse Clicked")
        let url = URL(string: "http://" + textField.text! + "/walkBackward");
        let request = URLRequest(url: url!);
        webView.load(request);
        print(url)
    }
    
    @objc func leftAction(sender: UIButton!) {
        print("Left Clicked")
        let url = URL(string: "http://" + textField.text! + "/turnLeft");
        let request = URLRequest(url: url!);
        webView.load(request);
        print(url)
    }
    
    @objc func rightAction(sender: UIButton!) {
        print("Right Clicked")
        let url = URL(string: "http://" + textField.text! + "/turnRight");
        let request = URLRequest(url: url!);
        webView.load(request);
        print(url)
    }
    
    @objc func bowAction(sender: UIButton!) {
        print("Bow Clicked")
        let url = URL(string: "http://" + textField.text! + "/bow");
        let request = URLRequest(url: url!);
        webView.load(request);
        print(url)
    }
    
    @objc func bendBackAction(sender: UIButton!) {
        print("Bend Back Clicked")
        let url = URL(string: "http://" + textField.text! + "/bendBack");
        let request = URLRequest(url: url!);
        webView.load(request);
        print(url)
    }
    
    @objc func jumpUpAction(sender: UIButton!) {
        print("Jump Up Clicked")
        let url = URL(string: "http://" + textField.text! + "/jumpUp");
        let request = URLRequest(url: url!);
        webView.load(request);
        print(url)
    }
    
    @objc func jumpBackAction(sender: UIButton!) {
        print("Jump Back Clicked")
        let url = URL(string: "http://" + textField.text! + "/jumpBack");
        let request = URLRequest(url: url!);
        webView.load(request);
        print(url)
    }
    
    @objc func pushUpAction(sender: UIButton!) {
        print("Push Up Clicked")
        let url = URL(string: "http://" + textField.text! + "/pushUp");
        let request = URLRequest(url: url!);
        webView.load(request);
        print(url)
    }


}

